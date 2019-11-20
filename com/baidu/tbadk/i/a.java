package com.baidu.tbadk.i;

import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public int bUD = 300;
    public int bUE = 5000;
    public int bUF = 10000;
    public int bUG = 1500;
    public int bUH = 3000;
    public int bUI = SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME;
    public boolean bUJ = true;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int optInt = jSONObject.optInt("wifiSlow", -1);
                if (optInt > 0) {
                    this.bUD = optInt;
                }
                int optInt2 = jSONObject.optInt("threeGSlow", -1);
                if (optInt2 > 0) {
                    this.bUE = optInt2;
                }
                int optInt3 = jSONObject.optInt("twoGSlow", -1);
                if (optInt3 > 0) {
                    this.bUF = optInt3;
                }
                int optInt4 = jSONObject.optInt("wifiLog", -1);
                if (optInt4 > 0) {
                    this.bUG = optInt4;
                }
                int optInt5 = jSONObject.optInt("threeGLog", -1);
                if (optInt5 > 0) {
                    this.bUH = optInt5;
                }
                int optInt6 = jSONObject.optInt("twoGLog", -1);
                if (optInt6 > 0) {
                    this.bUI = optInt6;
                }
                this.bUJ = jSONObject.optInt("mobile_cdn_switch", 1) == 1;
            } catch (Exception e) {
            }
        }
    }
}
