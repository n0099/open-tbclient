package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes3.dex */
public class PayMemberInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f12809e;

    /* renamed from: f  reason: collision with root package name */
    public int f12810f;

    /* renamed from: g  reason: collision with root package name */
    public String f12811g;

    /* renamed from: h  reason: collision with root package name */
    public String f12812h;

    public String getUrl() {
        return this.f12811g;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f12809e = jSONObject.optInt("props_id");
        this.f12810f = jSONObject.optInt("end_time", 0);
        this.f12811g = jSONObject.optString(this.f12811g, "");
        this.f12812h = jSONObject.optString("expire_remind");
    }

    public int s() {
        return this.f12810f;
    }

    public String t() {
        return this.f12812h;
    }

    public int u() {
        return this.f12809e;
    }

    public void v(PayMemberInfo payMemberInfo) {
        if (payMemberInfo == null) {
            return;
        }
        Integer num = payMemberInfo.props_id;
        if (num != null) {
            this.f12809e = num.intValue();
        }
        Integer num2 = payMemberInfo.end_time;
        if (num2 != null) {
            this.f12810f = num2.intValue();
        }
        this.f12811g = payMemberInfo.url;
        this.f12812h = payMemberInfo.expire_remind;
    }

    public void w(String str) {
        this.f12812h = str;
    }
}
