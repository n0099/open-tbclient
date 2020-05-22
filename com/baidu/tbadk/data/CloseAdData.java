package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int ejM = 1;
    private int ejN;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ejM = jSONObject.optInt("is_open");
            this.ejN = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.ejM = vipCloseAd.is_open.intValue();
            this.ejN = vipCloseAd.vip_close.intValue();
        }
    }

    public int bcr() {
        return this.ejM;
    }

    public int bcs() {
        return this.ejN;
    }
}
