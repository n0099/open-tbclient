package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    public static final int ERROR_CODE_NOT_OPEN = 2420048;
    private int aAm = 1;
    private int aAn;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAm = jSONObject.optInt("is_open");
            this.aAn = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aAm = vipCloseAd.is_open.intValue();
            this.aAn = vipCloseAd.vip_close.intValue();
        }
    }

    public int Cr() {
        return this.aAm;
    }

    public int Cs() {
        return this.aAn;
    }
}
