package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int aBl = 1;
    private int aBm;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aBl = jSONObject.optInt("is_open");
            this.aBm = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aBl = vipCloseAd.is_open.intValue();
            this.aBm = vipCloseAd.vip_close.intValue();
        }
    }

    public int CY() {
        return this.aBl;
    }

    public int CZ() {
        return this.aBm;
    }
}
