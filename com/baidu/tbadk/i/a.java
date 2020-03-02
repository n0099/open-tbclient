package com.baidu.tbadk.i;

import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public int cLl = 300;
    public int cLm = 5000;
    public int cLn = 10000;
    public int cLo = 1500;
    public int cLp = 3000;
    public int cLq = SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME;
    public boolean cLr = true;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int optInt = jSONObject.optInt("wifiSlow", -1);
                if (optInt > 0) {
                    this.cLl = optInt;
                }
                int optInt2 = jSONObject.optInt("threeGSlow", -1);
                if (optInt2 > 0) {
                    this.cLm = optInt2;
                }
                int optInt3 = jSONObject.optInt("twoGSlow", -1);
                if (optInt3 > 0) {
                    this.cLn = optInt3;
                }
                int optInt4 = jSONObject.optInt("wifiLog", -1);
                if (optInt4 > 0) {
                    this.cLo = optInt4;
                }
                int optInt5 = jSONObject.optInt("threeGLog", -1);
                if (optInt5 > 0) {
                    this.cLp = optInt5;
                }
                int optInt6 = jSONObject.optInt("twoGLog", -1);
                if (optInt6 > 0) {
                    this.cLq = optInt6;
                }
                this.cLr = jSONObject.optInt("mobile_cdn_switch", 1) == 1;
            } catch (Exception e) {
            }
        }
    }
}
