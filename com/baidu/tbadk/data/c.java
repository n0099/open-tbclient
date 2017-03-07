package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class c {
    private int awR = 1;
    private int awS;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.awR = jSONObject.optInt("is_open");
            this.awS = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.awR = vipCloseAd.is_open.intValue();
            this.awS = vipCloseAd.vip_close.intValue();
        }
    }

    public int Cb() {
        return this.awR;
    }

    public int Cc() {
        return this.awS;
    }
}
