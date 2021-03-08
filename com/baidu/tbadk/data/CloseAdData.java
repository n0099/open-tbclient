package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int fBt = 1;
    private int fBu;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fBt = jSONObject.optInt("is_open");
            this.fBu = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.fBt = vipCloseAd.is_open.intValue();
            this.fBu = vipCloseAd.vip_close.intValue();
        }
    }

    public int bAz() {
        return this.fBt;
    }

    public int bAA() {
        return this.fBu;
    }
}
