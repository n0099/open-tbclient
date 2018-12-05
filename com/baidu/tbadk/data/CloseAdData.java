package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int aWL = 1;
    private int aWM;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aWL = jSONObject.optInt("is_open");
            this.aWM = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.aWL = vipCloseAd.is_open.intValue();
            this.aWM = vipCloseAd.vip_close.intValue();
        }
    }

    public int Lu() {
        return this.aWL;
    }

    public int Lv() {
        return this.aWM;
    }
}
