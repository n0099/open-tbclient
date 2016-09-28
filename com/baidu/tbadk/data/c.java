package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class c {
    private int arU = 1;
    private int arV;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.arU = jSONObject.optInt("is_open");
            this.arV = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.arU = vipCloseAd.is_open.intValue();
            this.arV = vipCloseAd.vip_close.intValue();
        }
    }

    public int BU() {
        return this.arU;
    }

    public int BV() {
        return this.arV;
    }
}
