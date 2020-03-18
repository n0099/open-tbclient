package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int dvE = 1;
    private int dvF;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dvE = jSONObject.optInt("is_open");
            this.dvF = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.dvE = vipCloseAd.is_open.intValue();
            this.dvF = vipCloseAd.vip_close.intValue();
        }
    }

    public int aNO() {
        return this.dvE;
    }

    public int aNP() {
        return this.dvF;
    }
}
