package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private static f azl;
    public final String azh = "2g";
    public final String azi = "3g";
    public final String azj = "4g";
    public final String azk = "wifi";
    public HashMap<String, String> azm = new HashMap<>();
    public HashMap<String, String> azn = new HashMap<>();
    public HashMap<String, String> azo = new HashMap<>();
    public String azp;

    public static synchronized f BS() {
        f fVar;
        synchronized (f.class) {
            if (azl == null) {
                azl = new f();
            }
            fVar = azl;
        }
        return fVar;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("upload_file_frequency");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("2g");
                    String optString2 = optJSONObject.optString("3g");
                    String optString3 = optJSONObject.optString("4g");
                    String optString4 = optJSONObject.optString("wifi");
                    if (optString != null) {
                        this.azm.put("2g", optString);
                    }
                    if (optString2 != null) {
                        this.azm.put("3g", optString2);
                    }
                    if (optString3 != null) {
                        this.azm.put("4g", optString3);
                    }
                    if (optString4 != null) {
                        this.azm.put("wifi", optString4);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
                if (optJSONObject2 != null) {
                    String optString5 = optJSONObject2.optString("2g");
                    String optString6 = optJSONObject2.optString("3g");
                    String optString7 = optJSONObject2.optString("4g");
                    String optString8 = optJSONObject2.optString("wifi");
                    if (optString5 != null) {
                        this.azn.put("2g", optString5);
                    }
                    if (optString6 != null) {
                        this.azn.put("3g", optString6);
                    }
                    if (optString7 != null) {
                        this.azn.put("4g", optString7);
                    }
                    if (optString8 != null) {
                        this.azn.put("wifi", optString8);
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
                if (optJSONObject3 != null) {
                    String optString9 = optJSONObject3.optString("2g");
                    String optString10 = optJSONObject3.optString("3g");
                    String optString11 = optJSONObject3.optString("4g");
                    String optString12 = optJSONObject3.optString("wifi");
                    if (optString9 != null) {
                        this.azo.put("2g", optString9);
                    }
                    if (optString10 != null) {
                        this.azo.put("3g", optString10);
                    }
                    if (optString11 != null) {
                        this.azo.put("4g", optString11);
                    }
                    if (optString12 != null) {
                        this.azo.put("wifi", optString12);
                    }
                }
                this.azp = jSONObject.optString("is_on");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
