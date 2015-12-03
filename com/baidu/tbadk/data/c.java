package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static c apo;
    public final String apk = "2g";
    public final String apl = "3g";
    public final String apm = "4g";
    public final String apn = "wifi";
    public HashMap<String, String> apq = new HashMap<>();
    public HashMap<String, String> apr = new HashMap<>();
    public HashMap<String, String> aps = new HashMap<>();
    public String apt;

    public static synchronized c AT() {
        c cVar;
        synchronized (c.class) {
            if (apo == null) {
                apo = new c();
            }
            cVar = apo;
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
                        this.apq.put("2g", optString);
                    }
                    if (optString2 != null) {
                        this.apq.put("3g", optString2);
                    }
                    if (optString3 != null) {
                        this.apq.put("4g", optString3);
                    }
                    if (optString4 != null) {
                        this.apq.put("wifi", optString4);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
                if (optJSONObject2 != null) {
                    String optString5 = optJSONObject2.optString("2g");
                    String optString6 = optJSONObject2.optString("3g");
                    String optString7 = optJSONObject2.optString("4g");
                    String optString8 = optJSONObject2.optString("wifi");
                    if (optString5 != null) {
                        this.apr.put("2g", optString5);
                    }
                    if (optString6 != null) {
                        this.apr.put("3g", optString6);
                    }
                    if (optString7 != null) {
                        this.apr.put("4g", optString7);
                    }
                    if (optString8 != null) {
                        this.apr.put("wifi", optString8);
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
                if (optJSONObject3 != null) {
                    String optString9 = optJSONObject3.optString("2g");
                    String optString10 = optJSONObject3.optString("3g");
                    String optString11 = optJSONObject3.optString("4g");
                    String optString12 = optJSONObject3.optString("wifi");
                    if (optString9 != null) {
                        this.aps.put("2g", optString9);
                    }
                    if (optString10 != null) {
                        this.aps.put("3g", optString10);
                    }
                    if (optString11 != null) {
                        this.aps.put("4g", optString11);
                    }
                    if (optString12 != null) {
                        this.aps.put("wifi", optString12);
                    }
                }
                this.apt = jSONObject.optString("is_on");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
