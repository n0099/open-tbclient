package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    public static final int ERROR_CODE_NOT_OPEN = 2420048;
    private int ayU = 1;
    private int ayV;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ayU = jSONObject.optInt("is_open");
            this.ayV = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.ayU = vipCloseAd.is_open.intValue();
            this.ayV = vipCloseAd.vip_close.intValue();
        }
    }

    public int Cj() {
        return this.ayU;
    }

    public int Ck() {
        return this.ayV;
    }
}
