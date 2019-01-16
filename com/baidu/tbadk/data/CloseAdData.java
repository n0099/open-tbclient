package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int aXw = 1;
    private int aXx;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aXw = jSONObject.optInt("is_open");
            this.aXx = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aXw = vipCloseAd.is_open.intValue();
            this.aXx = vipCloseAd.vip_close.intValue();
        }
    }

    public int LK() {
        return this.aXw;
    }

    public int LL() {
        return this.aXx;
    }
}
