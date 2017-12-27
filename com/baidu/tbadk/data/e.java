package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static e box;
    public String boB;
    public final String bot = "2g";
    public final String bou = "3g";
    public final String bov = "4g";
    public final String bow = "wifi";
    public HashMap<String, String> boy = new HashMap<>();
    public HashMap<String, String> boz = new HashMap<>();
    public HashMap<String, String> boA = new HashMap<>();

    public static synchronized e Ka() {
        e eVar;
        synchronized (e.class) {
            if (box == null) {
                box = new e();
            }
            eVar = box;
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
                        this.boy.put("2g", optString);
                    }
                    if (optString2 != null) {
                        this.boy.put("3g", optString2);
                    }
                    if (optString3 != null) {
                        this.boy.put("4g", optString3);
                    }
                    if (optString4 != null) {
                        this.boy.put("wifi", optString4);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
                if (optJSONObject2 != null) {
                    String optString5 = optJSONObject2.optString("2g");
                    String optString6 = optJSONObject2.optString("3g");
                    String optString7 = optJSONObject2.optString("4g");
                    String optString8 = optJSONObject2.optString("wifi");
                    if (optString5 != null) {
                        this.boz.put("2g", optString5);
                    }
                    if (optString6 != null) {
                        this.boz.put("3g", optString6);
                    }
                    if (optString7 != null) {
                        this.boz.put("4g", optString7);
                    }
                    if (optString8 != null) {
                        this.boz.put("wifi", optString8);
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
                if (optJSONObject3 != null) {
                    String optString9 = optJSONObject3.optString("2g");
                    String optString10 = optJSONObject3.optString("3g");
                    String optString11 = optJSONObject3.optString("4g");
                    String optString12 = optJSONObject3.optString("wifi");
                    if (optString9 != null) {
                        this.boA.put("2g", optString9);
                    }
                    if (optString10 != null) {
                        this.boA.put("3g", optString10);
                    }
                    if (optString11 != null) {
                        this.boA.put("4g", optString11);
                    }
                    if (optString12 != null) {
                        this.boA.put("wifi", optString12);
                    }
                }
                this.boB = jSONObject.optString("is_on");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
