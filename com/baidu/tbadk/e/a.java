package com.baidu.tbadk.e;

import com.baidu.tbadk.TbConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public int aHa = 300;
    public int aHb = 5000;
    public int aHc = 10000;
    public int aHd = TbConfig.POST_IMAGE_SMALL;
    public int aHe = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    public int aHf = 6000;
    public boolean aHg = true;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int optInt = jSONObject.optInt("wifiSlow", -1);
                if (optInt > 0) {
                    this.aHa = optInt;
                }
                int optInt2 = jSONObject.optInt("threeGSlow", -1);
                if (optInt2 > 0) {
                    this.aHb = optInt2;
                }
                int optInt3 = jSONObject.optInt("twoGSlow", -1);
                if (optInt3 > 0) {
                    this.aHc = optInt3;
                }
                int optInt4 = jSONObject.optInt("wifiLog", -1);
                if (optInt4 > 0) {
                    this.aHd = optInt4;
                }
                int optInt5 = jSONObject.optInt("threeGLog", -1);
                if (optInt5 > 0) {
                    this.aHe = optInt5;
                }
                int optInt6 = jSONObject.optInt("twoGLog", -1);
                if (optInt6 > 0) {
                    this.aHf = optInt6;
                }
                this.aHg = jSONObject.optInt("mobile_cdn_switch", 1) == 1;
            } catch (Exception e) {
            }
        }
    }
}
