package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int bqL = 1;
    private int bqM;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bqL = jSONObject.optInt("is_open");
            this.bqM = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.bqL = vipCloseAd.is_open.intValue();
            this.bqM = vipCloseAd.vip_close.intValue();
        }
    }

    public int Ku() {
        return this.bqL;
    }

    public int Kv() {
        return this.bqM;
    }
}
