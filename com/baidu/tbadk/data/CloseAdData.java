package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int aWO = 1;
    private int aWP;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aWO = jSONObject.optInt("is_open");
            this.aWP = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aWO = vipCloseAd.is_open.intValue();
            this.aWP = vipCloseAd.vip_close.intValue();
        }
    }

    public int Lv() {
        return this.aWO;
    }

    public int Lw() {
        return this.aWP;
    }
}
