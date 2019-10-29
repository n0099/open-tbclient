package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int cDP = 1;
    private int cDQ;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cDP = jSONObject.optInt("is_open");
            this.cDQ = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.cDP = vipCloseAd.is_open.intValue();
            this.cDQ = vipCloseAd.vip_close.intValue();
        }
    }

    public int att() {
        return this.cDP;
    }

    public int atu() {
        return this.cDQ;
    }
}
