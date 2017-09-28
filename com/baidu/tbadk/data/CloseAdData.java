package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    public static final int ERROR_CODE_NOT_OPEN = 2420048;
    private int ayP = 1;
    private int ayQ;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ayP = jSONObject.optInt("is_open");
            this.ayQ = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.ayP = vipCloseAd.is_open.intValue();
            this.ayQ = vipCloseAd.vip_close.intValue();
        }
    }

    public int BP() {
        return this.ayP;
    }

    public int BQ() {
        return this.ayQ;
    }
}
