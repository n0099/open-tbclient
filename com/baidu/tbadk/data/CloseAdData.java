package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int fzU = 1;
    private int fzV;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fzU = jSONObject.optInt("is_open");
            this.fzV = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.fzU = vipCloseAd.is_open.intValue();
            this.fzV = vipCloseAd.vip_close.intValue();
        }
    }

    public int bAw() {
        return this.fzU;
    }

    public int bAx() {
        return this.fzV;
    }
}
