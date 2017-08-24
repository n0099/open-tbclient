package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    public static final int ERROR_CODE_NOT_OPEN = 2420048;
    private int aAn = 1;
    private int aAo;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAn = jSONObject.optInt("is_open");
            this.aAo = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aAn = vipCloseAd.is_open.intValue();
            this.aAo = vipCloseAd.vip_close.intValue();
        }
    }

    public int Cr() {
        return this.aAn;
    }

    public int Cs() {
        return this.aAo;
    }
}
