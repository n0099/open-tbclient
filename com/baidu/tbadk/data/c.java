package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class c {
    private int axo = 1;
    private int axp;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axo = jSONObject.optInt("is_open");
            this.axp = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.axo = vipCloseAd.is_open.intValue();
            this.axp = vipCloseAd.vip_close.intValue();
        }
    }

    public int BK() {
        return this.axo;
    }

    public int BL() {
        return this.axp;
    }
}
