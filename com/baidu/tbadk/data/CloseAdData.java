package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int bqV = 1;
    private int bqW;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bqV = jSONObject.optInt("is_open");
            this.bqW = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.bqV = vipCloseAd.is_open.intValue();
            this.bqW = vipCloseAd.vip_close.intValue();
        }
    }

    public int Ku() {
        return this.bqV;
    }

    public int Kv() {
        return this.bqW;
    }
}
