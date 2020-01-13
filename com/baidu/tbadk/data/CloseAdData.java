package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int dqV = 1;
    private int dqW;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dqV = jSONObject.optInt("is_open");
            this.dqW = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.dqV = vipCloseAd.is_open.intValue();
            this.dqW = vipCloseAd.vip_close.intValue();
        }
    }

    public int aLl() {
        return this.dqV;
    }

    public int aLm() {
        return this.dqW;
    }
}
