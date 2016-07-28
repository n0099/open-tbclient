package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class c {
    private int apc = 1;
    private int apd;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.apc = jSONObject.optInt("is_open");
            this.apd = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.apc = vipCloseAd.is_open.intValue();
            this.apd = vipCloseAd.vip_close.intValue();
        }
    }

    public int AB() {
        return this.apc;
    }

    public int AC() {
        return this.apd;
    }
}
