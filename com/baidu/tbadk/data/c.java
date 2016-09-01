package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class c {
    private int asj = 1;
    private int ask;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.asj = jSONObject.optInt("is_open");
            this.ask = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.asj = vipCloseAd.is_open.intValue();
            this.ask = vipCloseAd.vip_close.intValue();
        }
    }

    public int BQ() {
        return this.asj;
    }

    public int BR() {
        return this.ask;
    }
}
