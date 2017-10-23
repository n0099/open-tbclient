package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    public static final int ERROR_CODE_NOT_OPEN = 2420048;
    private int ayD = 1;
    private int ayE;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ayD = jSONObject.optInt("is_open");
            this.ayE = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.ayD = vipCloseAd.is_open.intValue();
            this.ayE = vipCloseAd.vip_close.intValue();
        }
    }

    public int BJ() {
        return this.ayD;
    }

    public int BK() {
        return this.ayE;
    }
}
