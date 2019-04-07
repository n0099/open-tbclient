package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static e chb;
    public final String cgX = "2g";
    public final String cgY = "3g";
    public final String cgZ = "4g";
    public final String cha = "wifi";
    public HashMap<String, String> chc = new HashMap<>();
    public HashMap<String, String> chd = new HashMap<>();
    public HashMap<String, String> che = new HashMap<>();
    public String chf;

    public static synchronized e all() {
        e eVar;
        synchronized (e.class) {
            if (chb == null) {
                chb = new e();
            }
            eVar = chb;
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
                        this.chc.put("2g", optString);
                    }
                    if (optString2 != null) {
                        this.chc.put("3g", optString2);
                    }
                    if (optString3 != null) {
                        this.chc.put("4g", optString3);
                    }
                    if (optString4 != null) {
                        this.chc.put("wifi", optString4);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
                if (optJSONObject2 != null) {
                    String optString5 = optJSONObject2.optString("2g");
                    String optString6 = optJSONObject2.optString("3g");
                    String optString7 = optJSONObject2.optString("4g");
                    String optString8 = optJSONObject2.optString("wifi");
                    if (optString5 != null) {
                        this.chd.put("2g", optString5);
                    }
                    if (optString6 != null) {
                        this.chd.put("3g", optString6);
                    }
                    if (optString7 != null) {
                        this.chd.put("4g", optString7);
                    }
                    if (optString8 != null) {
                        this.chd.put("wifi", optString8);
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
                if (optJSONObject3 != null) {
                    String optString9 = optJSONObject3.optString("2g");
                    String optString10 = optJSONObject3.optString("3g");
                    String optString11 = optJSONObject3.optString("4g");
                    String optString12 = optJSONObject3.optString("wifi");
                    if (optString9 != null) {
                        this.che.put("2g", optString9);
                    }
                    if (optString10 != null) {
                        this.che.put("3g", optString10);
                    }
                    if (optString11 != null) {
                        this.che.put("4g", optString11);
                    }
                    if (optString12 != null) {
                        this.che.put("wifi", optString12);
                    }
                }
                this.chf = jSONObject.optString("is_on");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
