package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    public static final int ERROR_CODE_NOT_OPEN = 2420048;
    private int aAl = 1;
    private int aAm;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAl = jSONObject.optInt("is_open");
            this.aAm = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aAl = vipCloseAd.is_open.intValue();
            this.aAm = vipCloseAd.vip_close.intValue();
        }
    }

    public int Cr() {
        return this.aAl;
    }

    public int Cs() {
        return this.aAm;
    }
}
