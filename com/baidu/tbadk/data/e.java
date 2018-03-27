package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static e bqT;
    public final String bqP = "2g";
    public final String bqQ = "3g";
    public final String bqR = "4g";
    public final String bqS = "wifi";
    public HashMap<String, String> bqU = new HashMap<>();
    public HashMap<String, String> bqV = new HashMap<>();
    public HashMap<String, String> bqW = new HashMap<>();
    public String bqX;

    public static synchronized e Kx() {
        e eVar;
        synchronized (e.class) {
            if (bqT == null) {
                bqT = new e();
            }
            eVar = bqT;
        }
        return eVar;
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
                        this.bqU.put("2g", optString);
                    }
                    if (optString2 != null) {
                        this.bqU.put("3g", optString2);
                    }
                    if (optString3 != null) {
                        this.bqU.put("4g", optString3);
                    }
                    if (optString4 != null) {
                        this.bqU.put("wifi", optString4);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
                if (optJSONObject2 != null) {
                    String optString5 = optJSONObject2.optString("2g");
                    String optString6 = optJSONObject2.optString("3g");
                    String optString7 = optJSONObject2.optString("4g");
                    String optString8 = optJSONObject2.optString("wifi");
                    if (optString5 != null) {
                        this.bqV.put("2g", optString5);
                    }
                    if (optString6 != null) {
                        this.bqV.put("3g", optString6);
                    }
                    if (optString7 != null) {
                        this.bqV.put("4g", optString7);
                    }
                    if (optString8 != null) {
                        this.bqV.put("wifi", optString8);
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
                if (optJSONObject3 != null) {
                    String optString9 = optJSONObject3.optString("2g");
                    String optString10 = optJSONObject3.optString("3g");
                    String optString11 = optJSONObject3.optString("4g");
                    String optString12 = optJSONObject3.optString("wifi");
                    if (optString9 != null) {
                        this.bqW.put("2g", optString9);
                    }
                    if (optString10 != null) {
                        this.bqW.put("3g", optString10);
                    }
                    if (optString11 != null) {
                        this.bqW.put("4g", optString11);
                    }
                    if (optString12 != null) {
                        this.bqW.put("wifi", optString12);
                    }
                }
                this.bqX = jSONObject.optString("is_on");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
