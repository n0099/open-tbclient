package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    public static final int ERROR_CODE_NOT_OPEN = 2420048;
    private int azy = 1;
    private int azz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.azy = jSONObject.optInt("is_open");
            this.azz = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.azy = vipCloseAd.is_open.intValue();
            this.azz = vipCloseAd.vip_close.intValue();
        }
    }

    public int Cm() {
        return this.azy;
    }

    public int Cn() {
        return this.azz;
    }
}
