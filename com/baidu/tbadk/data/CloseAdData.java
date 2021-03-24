package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes3.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;

    /* renamed from: e  reason: collision with root package name */
    public int f13810e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f13811f;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f13810e = jSONObject.optInt("is_open");
        this.f13811f = jSONObject.optInt("vip_close");
    }

    public int s() {
        return this.f13810e;
    }

    public int t() {
        return this.f13811f;
    }

    public void u(VipCloseAd vipCloseAd) {
        if (vipCloseAd == null) {
            return;
        }
        this.f13810e = vipCloseAd.is_open.intValue();
        this.f13811f = vipCloseAd.vip_close.intValue();
    }
}
