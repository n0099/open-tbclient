package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int boy = 1;
    private int boz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.boy = jSONObject.optInt("is_open");
            this.boz = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.boy = vipCloseAd.is_open.intValue();
            this.boz = vipCloseAd.vip_close.intValue();
        }
    }

    public int JM() {
        return this.boy;
    }

    public int JN() {
        return this.boz;
    }
}
