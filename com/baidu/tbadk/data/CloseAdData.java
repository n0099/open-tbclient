package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int fxE = 1;
    private int fxF;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fxE = jSONObject.optInt("is_open");
            this.fxF = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.fxE = vipCloseAd.is_open.intValue();
            this.fxF = vipCloseAd.vip_close.intValue();
        }
    }

    public int bAe() {
        return this.fxE;
    }

    public int bAf() {
        return this.fxF;
    }
}
