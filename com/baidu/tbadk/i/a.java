package com.baidu.tbadk.i;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public int dWv = 300;
    public int dWw = 5000;
    public int dWx = 10000;
    public int dWy = 1500;
    public int dWz = 3000;
    public int dWA = 6000;
    public boolean dWB = true;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int optInt = jSONObject.optInt("wifiSlow", -1);
                if (optInt > 0) {
                    this.dWv = optInt;
                }
                int optInt2 = jSONObject.optInt("threeGSlow", -1);
                if (optInt2 > 0) {
                    this.dWw = optInt2;
                }
                int optInt3 = jSONObject.optInt("twoGSlow", -1);
                if (optInt3 > 0) {
                    this.dWx = optInt3;
                }
                int optInt4 = jSONObject.optInt("wifiLog", -1);
                if (optInt4 > 0) {
                    this.dWy = optInt4;
                }
                int optInt5 = jSONObject.optInt("threeGLog", -1);
                if (optInt5 > 0) {
                    this.dWz = optInt5;
                }
                int optInt6 = jSONObject.optInt("twoGLog", -1);
                if (optInt6 > 0) {
                    this.dWA = optInt6;
                }
                this.dWB = jSONObject.optInt("mobile_cdn_switch", 1) == 1;
            } catch (Exception e) {
            }
        }
    }
}
