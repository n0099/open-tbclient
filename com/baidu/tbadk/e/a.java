package com.baidu.tbadk.e;

import com.baidu.tbadk.TbConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public int aIn = 300;
    public int aIo = 5000;
    public int aIp = 10000;
    public int aIq = TbConfig.POST_IMAGE_SMALL;
    public int aIr = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    public int aIs = 6000;
    public boolean aIt = true;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int optInt = jSONObject.optInt("wifiSlow", -1);
                if (optInt > 0) {
                    this.aIn = optInt;
                }
                int optInt2 = jSONObject.optInt("threeGSlow", -1);
                if (optInt2 > 0) {
                    this.aIo = optInt2;
                }
                int optInt3 = jSONObject.optInt("twoGSlow", -1);
                if (optInt3 > 0) {
                    this.aIp = optInt3;
                }
                int optInt4 = jSONObject.optInt("wifiLog", -1);
                if (optInt4 > 0) {
                    this.aIq = optInt4;
                }
                int optInt5 = jSONObject.optInt("threeGLog", -1);
                if (optInt5 > 0) {
                    this.aIr = optInt5;
                }
                int optInt6 = jSONObject.optInt("twoGLog", -1);
                if (optInt6 > 0) {
                    this.aIs = optInt6;
                }
                this.aIt = jSONObject.optInt("mobile_cdn_switch", 1) == 1;
            } catch (Exception e) {
            }
        }
    }
}
