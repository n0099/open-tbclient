package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes3.dex */
public class CloseAdData extends OrmObject {
    public static final int ERROR_CODE_NOT_MEMBER = 1990043;

    /* renamed from: e  reason: collision with root package name */
    public int f12771e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f12772f;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f12771e = jSONObject.optInt("is_open");
        this.f12772f = jSONObject.optInt("vip_close");
    }

    public int w() {
        return this.f12771e;
    }

    public int x() {
        return this.f12772f;
    }

    public void y(VipCloseAd vipCloseAd) {
        if (vipCloseAd == null) {
            return;
        }
        this.f12771e = vipCloseAd.is_open.intValue();
        this.f12772f = vipCloseAd.vip_close.intValue();
    }
}
