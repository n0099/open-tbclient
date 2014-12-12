package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static c Wj;
    public final String Wf = "2g";
    public final String Wg = "3g";
    public final String Wh = "4g";
    public final String Wi = "wifi";
    public HashMap<String, String> Wk = new HashMap<>();
    public HashMap<String, String> Wl = new HashMap<>();
    public HashMap<String, String> Wm = new HashMap<>();
    public String Wn;

    public static synchronized c uo() {
        c cVar;
        synchronized (c.class) {
            if (Wj == null) {
                Wj = new c();
            }
            cVar = Wj;
        }
        return cVar;
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
                        this.Wk.put("2g", optString);
                    }
                    if (optString2 != null) {
                        this.Wk.put("3g", optString2);
                    }
                    if (optString3 != null) {
                        this.Wk.put("4g", optString3);
                    }
                    if (optString4 != null) {
                        this.Wk.put("wifi", optString4);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
                if (optJSONObject2 != null) {
                    String optString5 = optJSONObject2.optString("2g");
                    String optString6 = optJSONObject2.optString("3g");
                    String optString7 = optJSONObject2.optString("4g");
                    String optString8 = optJSONObject2.optString("wifi");
                    if (optString5 != null) {
                        this.Wl.put("2g", optString5);
                    }
                    if (optString6 != null) {
                        this.Wl.put("3g", optString6);
                    }
                    if (optString7 != null) {
                        this.Wl.put("4g", optString7);
                    }
                    if (optString8 != null) {
                        this.Wl.put("wifi", optString8);
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
                if (optJSONObject3 != null) {
                    String optString9 = optJSONObject3.optString("2g");
                    String optString10 = optJSONObject3.optString("3g");
                    String optString11 = optJSONObject3.optString("4g");
                    String optString12 = optJSONObject3.optString("wifi");
                    if (optString9 != null) {
                        this.Wm.put("2g", optString9);
                    }
                    if (optString10 != null) {
                        this.Wm.put("3g", optString10);
                    }
                    if (optString11 != null) {
                        this.Wm.put("4g", optString11);
                    }
                    if (optString12 != null) {
                        this.Wm.put("wifi", optString12);
                    }
                }
                this.Wn = jSONObject.optString("is_on");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
