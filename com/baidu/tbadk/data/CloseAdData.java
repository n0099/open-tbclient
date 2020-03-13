package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int dvr = 1;
    private int dvs;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dvr = jSONObject.optInt("is_open");
            this.dvs = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.dvr = vipCloseAd.is_open.intValue();
            this.dvs = vipCloseAd.vip_close.intValue();
        }
    }

    public int aNK() {
        return this.dvr;
    }

    public int aNL() {
        return this.dvs;
    }
}
