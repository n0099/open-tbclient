package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int dqK = 1;
    private int dqL;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dqK = jSONObject.optInt("is_open");
            this.dqL = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.dqK = vipCloseAd.is_open.intValue();
            this.dqL = vipCloseAd.vip_close.intValue();
        }
    }

    public int aKS() {
        return this.dqK;
    }

    public int aKT() {
        return this.dqL;
    }
}
