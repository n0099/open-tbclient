package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int aXx = 1;
    private int aXy;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aXx = jSONObject.optInt("is_open");
            this.aXy = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aXx = vipCloseAd.is_open.intValue();
            this.aXy = vipCloseAd.vip_close.intValue();
        }
    }

    public int LK() {
        return this.aXx;
    }

    public int LL() {
        return this.aXy;
    }
}
