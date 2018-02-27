package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int bqI = 1;
    private int bqJ;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bqI = jSONObject.optInt("is_open");
            this.bqJ = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.bqI = vipCloseAd.is_open.intValue();
            this.bqJ = vipCloseAd.vip_close.intValue();
        }
    }

    public int Kt() {
        return this.bqI;
    }

    public int Ku() {
        return this.bqJ;
    }
}
