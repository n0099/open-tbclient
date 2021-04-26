package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes3.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;

    /* renamed from: e  reason: collision with root package name */
    public int f13462e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f13463f;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f13462e = jSONObject.optInt("is_open");
        this.f13463f = jSONObject.optInt("vip_close");
    }

    public int s() {
        return this.f13462e;
    }

    public int t() {
        return this.f13463f;
    }

    public void u(VipCloseAd vipCloseAd) {
        if (vipCloseAd == null) {
            return;
        }
        this.f13462e = vipCloseAd.is_open.intValue();
        this.f13463f = vipCloseAd.vip_close.intValue();
    }
}
