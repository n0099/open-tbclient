package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes2.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int eJp = 1;
    private int eJq;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eJp = jSONObject.optInt("is_open");
            this.eJq = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.eJp = vipCloseAd.is_open.intValue();
            this.eJq = vipCloseAd.vip_close.intValue();
        }
    }

    public int bqP() {
        return this.eJp;
    }

    public int bqQ() {
        return this.eJq;
    }
}
