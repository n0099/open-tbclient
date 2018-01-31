package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int boH = 1;
    private int boI;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.boH = jSONObject.optInt("is_open");
            this.boI = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.boH = vipCloseAd.is_open.intValue();
            this.boI = vipCloseAd.vip_close.intValue();
        }
    }

    public int JO() {
        return this.boH;
    }

    public int JP() {
        return this.boI;
    }
}
