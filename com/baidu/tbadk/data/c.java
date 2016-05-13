package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class c {
    private int anG = 1;
    private int anH;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.anG = jSONObject.optInt("is_open");
            this.anH = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.anG = vipCloseAd.is_open.intValue();
            this.anH = vipCloseAd.vip_close.intValue();
        }
    }

    public int Aw() {
        return this.anG;
    }

    public int Ax() {
        return this.anH;
    }
}
