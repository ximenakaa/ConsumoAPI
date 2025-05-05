package ConsumoApi;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsumoApi {
    public static void main(String[] args) {
        try {
            // Solicitar petición
            URL url = new URL("http://www.metaweather.com/api/location/search/?query=Madrid");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Petición correcta
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                // Abrir scanner para flujo de datos
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } else {
                System.out.println("Error en la solicitud: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
