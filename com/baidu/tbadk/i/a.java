package com.baidu.tbadk.i;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public int eLK = 300;
    public int eLL = 5000;
    public int eLM = 10000;
    public int eLN = 1500;
    public int eLO = 2000;
    public int eLP = 3000;
    public int eLQ = 6000;
    public boolean eLR = true;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int optInt = jSONObject.optInt("wifiSlow", -1);
                if (optInt > 0) {
                    this.eLK = optInt;
                }
                int optInt2 = jSONObject.optInt("threeGSlow", -1);
                if (optInt2 > 0) {
                    this.eLL = optInt2;
                }
                int optInt3 = jSONObject.optInt("twoGSlow", -1);
                if (optInt3 > 0) {
                    this.eLM = optInt3;
                }
                int optInt4 = jSONObject.optInt("wifiLog", -1);
                if (optInt4 > 0) {
                    this.eLN = optInt4;
                }
                int optInt5 = jSONObject.optInt("threeGLog", -1);
                if (optInt5 > 0) {
                    this.eLP = optInt5;
                }
                int optInt6 = jSONObject.optInt("twoGLog", -1);
                if (optInt6 > 0) {
                    this.eLQ = optInt6;
                }
                this.eLR = jSONObject.optInt("mobile_cdn_switch", 1) == 1;
            } catch (Exception e) {
            }
        }
    }
}
