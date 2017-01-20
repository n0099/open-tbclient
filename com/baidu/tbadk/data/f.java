package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private static f arS;
    public final String arO = "2g";
    public final String arP = "3g";
    public final String arQ = "4g";
    public final String arR = "wifi";
    public HashMap<String, String> arT = new HashMap<>();
    public HashMap<String, String> arU = new HashMap<>();
    public HashMap<String, String> arV = new HashMap<>();
    public String arW;

    public static synchronized f BO() {
        f fVar;
        synchronized (f.class) {
            if (arS == null) {
                arS = new f();
            }
            fVar = arS;
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
                        this.arT.put("2g", optString);
                    }
                    if (optString2 != null) {
                        this.arT.put("3g", optString2);
                    }
                    if (optString3 != null) {
                        this.arT.put("4g", optString3);
                    }
                    if (optString4 != null) {
                        this.arT.put("wifi", optString4);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
                if (optJSONObject2 != null) {
                    String optString5 = optJSONObject2.optString("2g");
                    String optString6 = optJSONObject2.optString("3g");
                    String optString7 = optJSONObject2.optString("4g");
                    String optString8 = optJSONObject2.optString("wifi");
                    if (optString5 != null) {
                        this.arU.put("2g", optString5);
                    }
                    if (optString6 != null) {
                        this.arU.put("3g", optString6);
                    }
                    if (optString7 != null) {
                        this.arU.put("4g", optString7);
                    }
                    if (optString8 != null) {
                        this.arU.put("wifi", optString8);
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
                if (optJSONObject3 != null) {
                    String optString9 = optJSONObject3.optString("2g");
                    String optString10 = optJSONObject3.optString("3g");
                    String optString11 = optJSONObject3.optString("4g");
                    String optString12 = optJSONObject3.optString("wifi");
                    if (optString9 != null) {
                        this.arV.put("2g", optString9);
                    }
                    if (optString10 != null) {
                        this.arV.put("3g", optString10);
                    }
                    if (optString11 != null) {
                        this.arV.put("4g", optString11);
                    }
                    if (optString12 != null) {
                        this.arV.put("wifi", optString12);
                    }
                }
                this.arW = jSONObject.optString("is_on");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
