package com.baidu.tbadk.e;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public int RA = 300;
    public int RB = 5000;
    public int RC = 10000;
    public int RD = 1500;
    public int RE = 3000;
    public int RF = 6000;
    public boolean RG = true;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int optInt = jSONObject.optInt("wifiSlow", -1);
                if (optInt > 0) {
                    this.RA = optInt;
                }
                int optInt2 = jSONObject.optInt("threeGSlow", -1);
                if (optInt2 > 0) {
                    this.RB = optInt2;
                }
                int optInt3 = jSONObject.optInt("twoGSlow", -1);
                if (optInt3 > 0) {
                    this.RC = optInt3;
                }
                int optInt4 = jSONObject.optInt("wifiLog", -1);
                if (optInt4 > 0) {
                    this.RD = optInt4;
                }
                int optInt5 = jSONObject.optInt("threeGLog", -1);
                if (optInt5 > 0) {
                    this.RE = optInt5;
                }
                int optInt6 = jSONObject.optInt("twoGLog", -1);
                if (optInt6 > 0) {
                    this.RF = optInt6;
                }
                this.RG = jSONObject.optInt("mobile_cdn_switch", 1) == 1;
            } catch (Exception e) {
            }
        }
    }
}
