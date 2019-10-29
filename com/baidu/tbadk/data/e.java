package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static e cDR;
    public String isOn;
    public final String NET_TYPENAME_2G = BdNetTypeUtil.NET_TYPENAME_2G;
    public final String NET_TYPENAME_3G = BdNetTypeUtil.NET_TYPENAME_3G;
    public final String NET_TYPENAME_4G = BdNetTypeUtil.NET_TYPENAME_4G;
    public final String NET_TYPENAME_WIFI = "wifi";
    public HashMap<String, String> uploadFileFrequencyMap = new HashMap<>();
    public HashMap<String, String> uploadDataNumMap = new HashMap<>();
    public HashMap<String, String> mergeDataFrequencyMap = new HashMap<>();

    public static synchronized e atv() {
        e eVar;
        synchronized (e.class) {
            if (cDR == null) {
                cDR = new e();
            }
            eVar = cDR;
        }
        return eVar;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("upload_file_frequency");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(BdNetTypeUtil.NET_TYPENAME_2G);
                    String optString2 = optJSONObject.optString(BdNetTypeUtil.NET_TYPENAME_3G);
                    String optString3 = optJSONObject.optString(BdNetTypeUtil.NET_TYPENAME_4G);
                    String optString4 = optJSONObject.optString("wifi");
                    if (optString != null) {
                        this.uploadFileFrequencyMap.put(BdNetTypeUtil.NET_TYPENAME_2G, optString);
                    }
                    if (optString2 != null) {
                        this.uploadFileFrequencyMap.put(BdNetTypeUtil.NET_TYPENAME_3G, optString2);
                    }
                    if (optString3 != null) {
                        this.uploadFileFrequencyMap.put(BdNetTypeUtil.NET_TYPENAME_4G, optString3);
                    }
                    if (optString4 != null) {
                        this.uploadFileFrequencyMap.put("wifi", optString4);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
                if (optJSONObject2 != null) {
                    String optString5 = optJSONObject2.optString(BdNetTypeUtil.NET_TYPENAME_2G);
                    String optString6 = optJSONObject2.optString(BdNetTypeUtil.NET_TYPENAME_3G);
                    String optString7 = optJSONObject2.optString(BdNetTypeUtil.NET_TYPENAME_4G);
                    String optString8 = optJSONObject2.optString("wifi");
                    if (optString5 != null) {
                        this.uploadDataNumMap.put(BdNetTypeUtil.NET_TYPENAME_2G, optString5);
                    }
                    if (optString6 != null) {
                        this.uploadDataNumMap.put(BdNetTypeUtil.NET_TYPENAME_3G, optString6);
                    }
                    if (optString7 != null) {
                        this.uploadDataNumMap.put(BdNetTypeUtil.NET_TYPENAME_4G, optString7);
                    }
                    if (optString8 != null) {
                        this.uploadDataNumMap.put("wifi", optString8);
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
                if (optJSONObject3 != null) {
                    String optString9 = optJSONObject3.optString(BdNetTypeUtil.NET_TYPENAME_2G);
                    String optString10 = optJSONObject3.optString(BdNetTypeUtil.NET_TYPENAME_3G);
                    String optString11 = optJSONObject3.optString(BdNetTypeUtil.NET_TYPENAME_4G);
                    String optString12 = optJSONObject3.optString("wifi");
                    if (optString9 != null) {
                        this.mergeDataFrequencyMap.put(BdNetTypeUtil.NET_TYPENAME_2G, optString9);
                    }
                    if (optString10 != null) {
                        this.mergeDataFrequencyMap.put(BdNetTypeUtil.NET_TYPENAME_3G, optString10);
                    }
                    if (optString11 != null) {
                        this.mergeDataFrequencyMap.put(BdNetTypeUtil.NET_TYPENAME_4G, optString11);
                    }
                    if (optString12 != null) {
                        this.mergeDataFrequencyMap.put("wifi", optString12);
                    }
                }
                this.isOn = jSONObject.optString("is_on");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
