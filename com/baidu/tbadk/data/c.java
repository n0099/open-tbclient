package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class c {
    private int axh = 1;
    private int axi;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axh = jSONObject.optInt("is_open");
            this.axi = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.axh = vipCloseAd.is_open.intValue();
            this.axi = vipCloseAd.vip_close.intValue();
        }
    }

    public int Cz() {
        return this.axh;
    }

    public int CA() {
        return this.axi;
    }
}
