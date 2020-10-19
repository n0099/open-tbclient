package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int eXH = 1;
    private int eXI;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eXH = jSONObject.optInt("is_open");
            this.eXI = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.eXH = vipCloseAd.is_open.intValue();
            this.eXI = vipCloseAd.vip_close.intValue();
        }
    }

    public int buu() {
        return this.eXH;
    }

    public int buv() {
        return this.eXI;
    }
}
