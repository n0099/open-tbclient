package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int cpb = 1;
    private int cpc;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cpb = jSONObject.optInt("is_open");
            this.cpc = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.cpb = vipCloseAd.is_open.intValue();
            this.cpc = vipCloseAd.vip_close.intValue();
        }
    }

    public int aql() {
        return this.cpb;
    }

    public int aqm() {
        return this.cpc;
    }
}
