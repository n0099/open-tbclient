package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes3.dex */
public class PayMemberInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f13482e;

    /* renamed from: f  reason: collision with root package name */
    public int f13483f;

    /* renamed from: g  reason: collision with root package name */
    public String f13484g;

    /* renamed from: h  reason: collision with root package name */
    public String f13485h;

    public String getUrl() {
        return this.f13484g;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f13482e = jSONObject.optInt("props_id");
        this.f13483f = jSONObject.optInt("end_time", 0);
        this.f13484g = jSONObject.optString(this.f13484g, "");
        this.f13485h = jSONObject.optString("expire_remind");
    }

    public int s() {
        return this.f13483f;
    }

    public String t() {
        return this.f13485h;
    }

    public int u() {
        return this.f13482e;
    }

    public void v(PayMemberInfo payMemberInfo) {
        if (payMemberInfo == null) {
            return;
        }
        Integer num = payMemberInfo.props_id;
        if (num != null) {
            this.f13482e = num.intValue();
        }
        Integer num2 = payMemberInfo.end_time;
        if (num2 != null) {
            this.f13483f = num2.intValue();
        }
        this.f13484g = payMemberInfo.url;
        this.f13485h = payMemberInfo.expire_remind;
    }

    public void w(String str) {
        this.f13485h = str;
    }
}
