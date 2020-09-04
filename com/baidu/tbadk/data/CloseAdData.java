package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int eJt = 1;
    private int eJu;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eJt = jSONObject.optInt("is_open");
            this.eJu = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.eJt = vipCloseAd.is_open.intValue();
            this.eJu = vipCloseAd.vip_close.intValue();
        }
    }

    public int bqQ() {
        return this.eJt;
    }

    public int bqR() {
        return this.eJu;
    }
}
