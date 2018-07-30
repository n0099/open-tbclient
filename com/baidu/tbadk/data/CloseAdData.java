package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int aKJ = 1;
    private int aKK;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKJ = jSONObject.optInt("is_open");
            this.aKK = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aKJ = vipCloseAd.is_open.intValue();
            this.aKK = vipCloseAd.vip_close.intValue();
        }
    }

    public int GP() {
        return this.aKJ;
    }

    public int GQ() {
        return this.aKK;
    }
}
