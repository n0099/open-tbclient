package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int aBk = 1;
    private int aBl;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aBk = jSONObject.optInt("is_open");
            this.aBl = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aBk = vipCloseAd.is_open.intValue();
            this.aBl = vipCloseAd.vip_close.intValue();
        }
    }

    public int Da() {
        return this.aBk;
    }

    public int Db() {
        return this.aBl;
    }
}
