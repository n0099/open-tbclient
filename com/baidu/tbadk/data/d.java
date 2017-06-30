package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class d {
    private int ayc = 1;
    private int ayd;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ayc = jSONObject.optInt("is_open");
            this.ayd = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.ayc = vipCloseAd.is_open.intValue();
            this.ayd = vipCloseAd.vip_close.intValue();
        }
    }

    public int BY() {
        return this.ayc;
    }

    public int BZ() {
        return this.ayd;
    }
}
