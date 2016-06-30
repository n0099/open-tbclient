package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class c {
    private int aon = 1;
    private int aoo;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aon = jSONObject.optInt("is_open");
            this.aoo = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aon = vipCloseAd.is_open.intValue();
            this.aoo = vipCloseAd.vip_close.intValue();
        }
    }

    public int AB() {
        return this.aon;
    }

    public int AC() {
        return this.aoo;
    }
}
