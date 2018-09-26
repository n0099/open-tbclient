package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int aNW = 1;
    private int aNX;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNW = jSONObject.optInt("is_open");
            this.aNX = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aNW = vipCloseAd.is_open.intValue();
            this.aNX = vipCloseAd.vip_close.intValue();
        }
    }

    public int If() {
        return this.aNW;
    }

    public int Ig() {
        return this.aNX;
    }
}
