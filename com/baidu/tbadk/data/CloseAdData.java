package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int fsH = 1;
    private int fsI;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fsH = jSONObject.optInt("is_open");
            this.fsI = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.fsH = vipCloseAd.is_open.intValue();
            this.fsI = vipCloseAd.vip_close.intValue();
        }
    }

    public int bBC() {
        return this.fsH;
    }

    public int bBD() {
        return this.fsI;
    }
}
