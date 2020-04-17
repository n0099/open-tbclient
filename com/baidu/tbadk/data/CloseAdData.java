package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int dVy = 1;
    private int dVz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dVy = jSONObject.optInt("is_open");
            this.dVz = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.dVy = vipCloseAd.is_open.intValue();
            this.dVz = vipCloseAd.vip_close.intValue();
        }
    }

    public int aWk() {
        return this.dVy;
    }

    public int aWl() {
        return this.dVz;
    }
}
