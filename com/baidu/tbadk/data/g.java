package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private static g aAH;
    public final String aAD = "2g";
    public final String aAE = "3g";
    public final String aAF = "4g";
    public final String aAG = "wifi";
    public HashMap<String, String> aAI = new HashMap<>();
    public HashMap<String, String> aAJ = new HashMap<>();
    public HashMap<String, String> aAK = new HashMap<>();
    public String aAL;

    public static synchronized g Cu() {
        g gVar;
        synchronized (g.class) {
            if (aAH == null) {
                aAH = new g();
            }
            gVar = aAH;
        }
        return gVar;
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
                        this.aAI.put("2g", optString);
                    }
                    if (optString2 != null) {
                        this.aAI.put("3g", optString2);
                    }
                    if (optString3 != null) {
                        this.aAI.put("4g", optString3);
                    }
                    if (optString4 != null) {
                        this.aAI.put("wifi", optString4);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
                if (optJSONObject2 != null) {
                    String optString5 = optJSONObject2.optString("2g");
                    String optString6 = optJSONObject2.optString("3g");
                    String optString7 = optJSONObject2.optString("4g");
                    String optString8 = optJSONObject2.optString("wifi");
                    if (optString5 != null) {
                        this.aAJ.put("2g", optString5);
                    }
                    if (optString6 != null) {
                        this.aAJ.put("3g", optString6);
                    }
                    if (optString7 != null) {
                        this.aAJ.put("4g", optString7);
                    }
                    if (optString8 != null) {
                        this.aAJ.put("wifi", optString8);
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
                if (optJSONObject3 != null) {
                    String optString9 = optJSONObject3.optString("2g");
                    String optString10 = optJSONObject3.optString("3g");
                    String optString11 = optJSONObject3.optString("4g");
                    String optString12 = optJSONObject3.optString("wifi");
                    if (optString9 != null) {
                        this.aAK.put("2g", optString9);
                    }
                    if (optString10 != null) {
                        this.aAK.put("3g", optString10);
                    }
                    if (optString11 != null) {
                        this.aAK.put("4g", optString11);
                    }
                    if (optString12 != null) {
                        this.aAK.put("wifi", optString12);
                    }
                }
                this.aAL = jSONObject.optString("is_on");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
