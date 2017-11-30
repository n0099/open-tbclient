package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int azW = 1;
    private int azX;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.azW = jSONObject.optInt("is_open");
            this.azX = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.azW = vipCloseAd.is_open.intValue();
            this.azX = vipCloseAd.vip_close.intValue();
        }
    }

    public int Ct() {
        return this.azW;
    }

    public int Cu() {
        return this.azX;
    }
}
