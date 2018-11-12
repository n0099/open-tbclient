package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int aTo = 1;
    private int aTp;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aTo = jSONObject.optInt("is_open");
            this.aTp = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aTo = vipCloseAd.is_open.intValue();
            this.aTp = vipCloseAd.vip_close.intValue();
        }
    }

    public int Kq() {
        return this.aTo;
    }

    public int Kr() {
        return this.aTp;
    }
}
