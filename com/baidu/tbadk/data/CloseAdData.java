package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int flW = 1;
    private int flX;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.flW = jSONObject.optInt("is_open");
            this.flX = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.flW = vipCloseAd.is_open.intValue();
            this.flX = vipCloseAd.vip_close.intValue();
        }
    }

    public int byM() {
        return this.flW;
    }

    public int byN() {
        return this.flX;
    }
}
