package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int dvd = 1;
    private int dve;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dvd = jSONObject.optInt("is_open");
            this.dve = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.dvd = vipCloseAd.is_open.intValue();
            this.dve = vipCloseAd.vip_close.intValue();
        }
    }

    public int aNH() {
        return this.dvd;
    }

    public int aNI() {
        return this.dve;
    }
}
