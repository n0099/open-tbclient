package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class b {
    private int arQ = 1;
    private int arR;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.arQ = jSONObject.optInt("is_open");
            this.arR = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.arQ = vipCloseAd.is_open.intValue();
            this.arR = vipCloseAd.vip_close.intValue();
        }
    }

    public int CB() {
        return this.arQ;
    }

    public int CC() {
        return this.arR;
    }
}
