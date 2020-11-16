package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int fle = 1;
    private int flf;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fle = jSONObject.optInt("is_open");
            this.flf = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.fle = vipCloseAd.is_open.intValue();
            this.flf = vipCloseAd.vip_close.intValue();
        }
    }

    public int byc() {
        return this.fle;
    }

    public int byd() {
        return this.flf;
    }
}
