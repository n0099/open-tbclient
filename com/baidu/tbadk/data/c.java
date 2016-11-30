package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class c {
    private int asO = 1;
    private int asP;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.asO = jSONObject.optInt("is_open");
            this.asP = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.asO = vipCloseAd.is_open.intValue();
            this.asP = vipCloseAd.vip_close.intValue();
        }
    }

    public int Ca() {
        return this.asO;
    }

    public int Cb() {
        return this.asP;
    }
}
