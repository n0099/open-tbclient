package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static e cqE;
    public final String cqA = "2g";
    public final String cqB = "3g";
    public final String cqC = "4g";
    public final String cqD = IXAdSystemUtils.NT_WIFI;
    public HashMap<String, String> cqF = new HashMap<>();
    public HashMap<String, String> cqG = new HashMap<>();
    public HashMap<String, String> cqH = new HashMap<>();
    public String cqI;

    public static synchronized e arv() {
        e eVar;
        synchronized (e.class) {
            if (cqE == null) {
                cqE = new e();
            }
            eVar = cqE;
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
                    String optString4 = optJSONObject.optString(IXAdSystemUtils.NT_WIFI);
                    if (optString != null) {
                        this.cqF.put("2g", optString);
                    }
                    if (optString2 != null) {
                        this.cqF.put("3g", optString2);
                    }
                    if (optString3 != null) {
                        this.cqF.put("4g", optString3);
                    }
                    if (optString4 != null) {
                        this.cqF.put(IXAdSystemUtils.NT_WIFI, optString4);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
                if (optJSONObject2 != null) {
                    String optString5 = optJSONObject2.optString("2g");
                    String optString6 = optJSONObject2.optString("3g");
                    String optString7 = optJSONObject2.optString("4g");
                    String optString8 = optJSONObject2.optString(IXAdSystemUtils.NT_WIFI);
                    if (optString5 != null) {
                        this.cqG.put("2g", optString5);
                    }
                    if (optString6 != null) {
                        this.cqG.put("3g", optString6);
                    }
                    if (optString7 != null) {
                        this.cqG.put("4g", optString7);
                    }
                    if (optString8 != null) {
                        this.cqG.put(IXAdSystemUtils.NT_WIFI, optString8);
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
                if (optJSONObject3 != null) {
                    String optString9 = optJSONObject3.optString("2g");
                    String optString10 = optJSONObject3.optString("3g");
                    String optString11 = optJSONObject3.optString("4g");
                    String optString12 = optJSONObject3.optString(IXAdSystemUtils.NT_WIFI);
                    if (optString9 != null) {
                        this.cqH.put("2g", optString9);
                    }
                    if (optString10 != null) {
                        this.cqH.put("3g", optString10);
                    }
                    if (optString11 != null) {
                        this.cqH.put("4g", optString11);
                    }
                    if (optString12 != null) {
                        this.cqH.put(IXAdSystemUtils.NT_WIFI, optString12);
                    }
                }
                this.cqI = jSONObject.optString("is_on");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
