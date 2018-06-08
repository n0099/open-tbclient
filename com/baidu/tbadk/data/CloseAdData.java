package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int aJG = 1;
    private int aJH;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJG = jSONObject.optInt("is_open");
            this.aJH = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aJG = vipCloseAd.is_open.intValue();
            this.aJH = vipCloseAd.vip_close.intValue();
        }
    }

    public int GB() {
        return this.aJG;
    }

    public int GC() {
        return this.aJH;
    }
}
