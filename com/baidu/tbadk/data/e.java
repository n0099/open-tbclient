package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static e aXE;
    public final String aXA = "2g";
    public final String aXB = "3g";
    public final String aXC = "4g";
    public final String aXD = "wifi";
    public HashMap<String, String> aXF = new HashMap<>();
    public HashMap<String, String> aXG = new HashMap<>();
    public HashMap<String, String> aXH = new HashMap<>();
    public String aXI;

    public static synchronized e LN() {
        e eVar;
        synchronized (e.class) {
            if (aXE == null) {
                aXE = new e();
            }
            eVar = aXE;
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
                        this.aXF.put("2g", optString);
                    }
                    if (optString2 != null) {
                        this.aXF.put("3g", optString2);
                    }
                    if (optString3 != null) {
                        this.aXF.put("4g", optString3);
                    }
                    if (optString4 != null) {
                        this.aXF.put("wifi", optString4);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
                if (optJSONObject2 != null) {
                    String optString5 = optJSONObject2.optString("2g");
                    String optString6 = optJSONObject2.optString("3g");
                    String optString7 = optJSONObject2.optString("4g");
                    String optString8 = optJSONObject2.optString("wifi");
                    if (optString5 != null) {
                        this.aXG.put("2g", optString5);
                    }
                    if (optString6 != null) {
                        this.aXG.put("3g", optString6);
                    }
                    if (optString7 != null) {
                        this.aXG.put("4g", optString7);
                    }
                    if (optString8 != null) {
                        this.aXG.put("wifi", optString8);
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
                if (optJSONObject3 != null) {
                    String optString9 = optJSONObject3.optString("2g");
                    String optString10 = optJSONObject3.optString("3g");
                    String optString11 = optJSONObject3.optString("4g");
                    String optString12 = optJSONObject3.optString("wifi");
                    if (optString9 != null) {
                        this.aXH.put("2g", optString9);
                    }
                    if (optString10 != null) {
                        this.aXH.put("3g", optString10);
                    }
                    if (optString11 != null) {
                        this.aXH.put("4g", optString11);
                    }
                    if (optString12 != null) {
                        this.aXH.put("wifi", optString12);
                    }
                }
                this.aXI = jSONObject.optString("is_on");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
