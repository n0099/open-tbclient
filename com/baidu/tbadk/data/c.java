package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class c {
    private int asr = 1;
    private int ass;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.asr = jSONObject.optInt("is_open");
            this.ass = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.asr = vipCloseAd.is_open.intValue();
            this.ass = vipCloseAd.vip_close.intValue();
        }
    }

    public int BN() {
        return this.asr;
    }

    public int BO() {
        return this.ass;
    }
}
