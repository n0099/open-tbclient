package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int aAe = 1;
    private int aAf;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAe = jSONObject.optInt("is_open");
            this.aAf = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aAe = vipCloseAd.is_open.intValue();
            this.aAf = vipCloseAd.vip_close.intValue();
        }
    }

    public int Cu() {
        return this.aAe;
    }

    public int Cv() {
        return this.aAf;
    }
}
