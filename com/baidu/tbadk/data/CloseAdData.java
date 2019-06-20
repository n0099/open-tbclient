package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int cpc = 1;
    private int cpd;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cpc = jSONObject.optInt("is_open");
            this.cpd = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.cpc = vipCloseAd.is_open.intValue();
            this.cpd = vipCloseAd.vip_close.intValue();
        }
    }

    public int aql() {
        return this.cpc;
    }

    public int aqm() {
        return this.cpd;
    }
}
