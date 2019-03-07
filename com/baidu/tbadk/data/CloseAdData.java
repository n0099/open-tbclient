package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int cgR = 1;
    private int cgS;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cgR = jSONObject.optInt("is_open");
            this.cgS = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.cgR = vipCloseAd.is_open.intValue();
            this.cgS = vipCloseAd.vip_close.intValue();
        }
    }

    public int alm() {
        return this.cgR;
    }

    public int aln() {
        return this.cgS;
    }
}
