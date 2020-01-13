package com.baidu.tbadk.i;

import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public int cHh = 300;
    public int cHi = 5000;
    public int cHj = 10000;
    public int cHk = 1500;
    public int cHl = 3000;
    public int cHm = SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME;
    public boolean cHn = true;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int optInt = jSONObject.optInt("wifiSlow", -1);
                if (optInt > 0) {
                    this.cHh = optInt;
                }
                int optInt2 = jSONObject.optInt("threeGSlow", -1);
                if (optInt2 > 0) {
                    this.cHi = optInt2;
                }
                int optInt3 = jSONObject.optInt("twoGSlow", -1);
                if (optInt3 > 0) {
                    this.cHj = optInt3;
                }
                int optInt4 = jSONObject.optInt("wifiLog", -1);
                if (optInt4 > 0) {
                    this.cHk = optInt4;
                }
                int optInt5 = jSONObject.optInt("threeGLog", -1);
                if (optInt5 > 0) {
                    this.cHl = optInt5;
                }
                int optInt6 = jSONObject.optInt("twoGLog", -1);
                if (optInt6 > 0) {
                    this.cHm = optInt6;
                }
                this.cHn = jSONObject.optInt("mobile_cdn_switch", 1) == 1;
            } catch (Exception e) {
            }
        }
    }
}
