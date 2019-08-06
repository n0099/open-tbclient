package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int cqw = 1;
    private int cqx;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cqw = jSONObject.optInt("is_open");
            this.cqx = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.cqw = vipCloseAd.is_open.intValue();
            this.cqx = vipCloseAd.vip_close.intValue();
        }
    }

    public int ars() {
        return this.cqw;
    }

    public int art() {
        return this.cqx;
    }
}
