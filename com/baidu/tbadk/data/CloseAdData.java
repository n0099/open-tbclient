package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int aKD = 1;
    private int aKE;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKD = jSONObject.optInt("is_open");
            this.aKE = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aKD = vipCloseAd.is_open.intValue();
            this.aKE = vipCloseAd.vip_close.intValue();
        }
    }

    public int GT() {
        return this.aKD;
    }

    public int GU() {
        return this.aKE;
    }
}
