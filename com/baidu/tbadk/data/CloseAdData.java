package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int cgT = 1;
    private int cgU;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cgT = jSONObject.optInt("is_open");
            this.cgU = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.cgT = vipCloseAd.is_open.intValue();
            this.cgU = vipCloseAd.vip_close.intValue();
        }
    }

    public int ali() {
        return this.cgT;
    }

    public int alj() {
        return this.cgU;
    }
}
