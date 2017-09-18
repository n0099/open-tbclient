package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    public static final int ERROR_CODE_NOT_OPEN = 2420048;
    private int azv = 1;
    private int azw;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.azv = jSONObject.optInt("is_open");
            this.azw = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.azv = vipCloseAd.is_open.intValue();
            this.azw = vipCloseAd.vip_close.intValue();
        }
    }

    public int Cm() {
        return this.azv;
    }

    public int Cn() {
        return this.azw;
    }
}
