package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int dVD = 1;
    private int dVE;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dVD = jSONObject.optInt("is_open");
            this.dVE = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.dVD = vipCloseAd.is_open.intValue();
            this.dVE = vipCloseAd.vip_close.intValue();
        }
    }

    public int aWi() {
        return this.dVD;
    }

    public int aWj() {
        return this.dVE;
    }
}
