package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;
    private int cqp = 1;
    private int cqq;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cqp = jSONObject.optInt("is_open");
            this.cqq = jSONObject.optInt("vip_close");
        }
    }

    public void a(VipCloseAd vipCloseAd) {
        if (vipCloseAd != null) {
            this.cqp = vipCloseAd.is_open.intValue();
            this.cqq = vipCloseAd.vip_close.intValue();
        }
    }

    public int arq() {
        return this.cqp;
    }

    public int arr() {
        return this.cqq;
    }
}
