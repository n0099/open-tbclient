package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int azn = 1;
    private int azo;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.azn = jSONObject.optInt("is_open");
            this.azo = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.azn = vipCloseAd.is_open.intValue();
            this.azo = vipCloseAd.vip_close.intValue();
        }
    }

    public int BX() {
        return this.azn;
    }

    public int BY() {
        return this.azo;
    }
}
