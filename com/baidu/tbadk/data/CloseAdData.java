package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int fCm = 1;
    private int fCn;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fCm = jSONObject.optInt("is_open");
            this.fCn = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.fCm = vipCloseAd.is_open.intValue();
            this.fCn = vipCloseAd.vip_close.intValue();
        }
    }

    public int bDY() {
        return this.fCm;
    }

    public int bDZ() {
        return this.fCn;
    }
}
