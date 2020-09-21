package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int eLA = 1;
    private int eLB;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eLA = jSONObject.optInt("is_open");
            this.eLB = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.eLA = vipCloseAd.is_open.intValue();
            this.eLB = vipCloseAd.vip_close.intValue();
        }
    }

    public int brK() {
        return this.eLA;
    }

    public int brL() {
        return this.eLB;
    }
}
