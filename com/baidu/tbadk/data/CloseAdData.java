package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int cgU = 1;
    private int cgV;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cgU = jSONObject.optInt("is_open");
            this.cgV = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.cgU = vipCloseAd.is_open.intValue();
            this.cgV = vipCloseAd.vip_close.intValue();
        }
    }

    public int ali() {
        return this.cgU;
    }

    public int alj() {
        return this.cgV;
    }
}
