package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int cCY = 1;
    private int cCZ;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cCY = jSONObject.optInt("is_open");
            this.cCZ = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.cCY = vipCloseAd.is_open.intValue();
            this.cCZ = vipCloseAd.vip_close.intValue();
        }
    }

    public int atr() {
        return this.cCY;
    }

    public int ats() {
        return this.cCZ;
    }
}
