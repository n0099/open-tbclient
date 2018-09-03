package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int aKG = 1;
    private int aKH;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKG = jSONObject.optInt("is_open");
            this.aKH = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aKG = vipCloseAd.is_open.intValue();
            this.aKH = vipCloseAd.vip_close.intValue();
        }
    }

    public int GP() {
        return this.aKG;
    }

    public int GQ() {
        return this.aKH;
    }
}
