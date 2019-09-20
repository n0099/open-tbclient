package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int crr = 1;
    private int crs;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.crr = jSONObject.optInt("is_open");
            this.crs = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.crr = vipCloseAd.is_open.intValue();
            this.crs = vipCloseAd.vip_close.intValue();
        }
    }

    public int arE() {
        return this.crr;
    }

    public int arF() {
        return this.crs;
    }
}
