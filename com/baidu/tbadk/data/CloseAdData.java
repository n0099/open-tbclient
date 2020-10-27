package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int fgd = 1;
    private int fge;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fgd = jSONObject.optInt("is_open");
            this.fge = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.fgd = vipCloseAd.is_open.intValue();
            this.fge = vipCloseAd.vip_close.intValue();
        }
    }

    public int bwn() {
        return this.fgd;
    }

    public int bwo() {
        return this.fge;
    }
}
