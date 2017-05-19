package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static e axC;
    public String axG;
    public final String axy = "2g";
    public final String axz = "3g";
    public final String axA = "4g";
    public final String axB = "wifi";
    public HashMap<String, String> axD = new HashMap<>();
    public HashMap<String, String> axE = new HashMap<>();
    public HashMap<String, String> axF = new HashMap<>();

    public static synchronized e BM() {
        e eVar;
        synchronized (e.class) {
            if (axC == null) {
                axC = new e();
            }
            eVar = axC;
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
                        this.axD.put("2g", optString);
                    }
                    if (optString2 != null) {
                        this.axD.put("3g", optString2);
                    }
                    if (optString3 != null) {
                        this.axD.put("4g", optString3);
                    }
                    if (optString4 != null) {
                        this.axD.put("wifi", optString4);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
                if (optJSONObject2 != null) {
                    String optString5 = optJSONObject2.optString("2g");
                    String optString6 = optJSONObject2.optString("3g");
                    String optString7 = optJSONObject2.optString("4g");
                    String optString8 = optJSONObject2.optString("wifi");
                    if (optString5 != null) {
                        this.axE.put("2g", optString5);
                    }
                    if (optString6 != null) {
                        this.axE.put("3g", optString6);
                    }
                    if (optString7 != null) {
                        this.axE.put("4g", optString7);
                    }
                    if (optString8 != null) {
                        this.axE.put("wifi", optString8);
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
                if (optJSONObject3 != null) {
                    String optString9 = optJSONObject3.optString("2g");
                    String optString10 = optJSONObject3.optString("3g");
                    String optString11 = optJSONObject3.optString("4g");
                    String optString12 = optJSONObject3.optString("wifi");
                    if (optString9 != null) {
                        this.axF.put("2g", optString9);
                    }
                    if (optString10 != null) {
                        this.axF.put("3g", optString10);
                    }
                    if (optString11 != null) {
                        this.axF.put("4g", optString11);
                    }
                    if (optString12 != null) {
                        this.axF.put("wifi", optString12);
                    }
                }
                this.axG = jSONObject.optString("is_on");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
