package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int eyR = 1;
    private int eyS;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eyR = jSONObject.optInt("is_open");
            this.eyS = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.eyR = vipCloseAd.is_open.intValue();
            this.eyS = vipCloseAd.vip_close.intValue();
        }
    }

    public int bid() {
        return this.eyR;
    }

    public int bie() {
        return this.eyS;
    }
}
