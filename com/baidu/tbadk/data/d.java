package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class d {
    private int axa = 1;
    private int axb;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axa = jSONObject.optInt("is_open");
            this.axb = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.axa = vipCloseAd.is_open.intValue();
            this.axb = vipCloseAd.vip_close.intValue();
        }
    }

    public int BD() {
        return this.axa;
    }

    public int BE() {
        return this.axb;
    }
}
