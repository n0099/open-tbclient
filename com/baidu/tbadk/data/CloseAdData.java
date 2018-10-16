package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int aSy = 1;
    private int aSz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSy = jSONObject.optInt("is_open");
            this.aSz = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aSy = vipCloseAd.is_open.intValue();
            this.aSz = vipCloseAd.vip_close.intValue();
        }
    }

    public int Ke() {
        return this.aSy;
    }

    public int Kf() {
        return this.aSz;
    }
}
