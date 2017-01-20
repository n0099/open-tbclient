package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class c {
    private int arw = 1;
    private int arx;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.arw = jSONObject.optInt("is_open");
            this.arx = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.arw = vipCloseAd.is_open.intValue();
            this.arx = vipCloseAd.vip_close.intValue();
        }
    }

    public int BI() {
        return this.arw;
    }

    public int BJ() {
        return this.arx;
    }
}
