package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int dve = 1;
    private int dvf;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dve = jSONObject.optInt("is_open");
            this.dvf = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.dve = vipCloseAd.is_open.intValue();
            this.dvf = vipCloseAd.vip_close.intValue();
        }
    }

    public int aNJ() {
        return this.dve;
    }

    public int aNK() {
        return this.dvf;
    }
}
