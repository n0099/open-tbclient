package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class c {
    private int axj = 1;
    private int axk;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axj = jSONObject.optInt("is_open");
            this.axk = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.axj = vipCloseAd.is_open.intValue();
            this.axk = vipCloseAd.vip_close.intValue();
        }
    }

    public int Cz() {
        return this.axj;
    }

    public int CA() {
        return this.axk;
    }
}
