package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes3.dex */
public class PayMemberInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f13490e;

    /* renamed from: f  reason: collision with root package name */
    public int f13491f;

    /* renamed from: g  reason: collision with root package name */
    public String f13492g;

    /* renamed from: h  reason: collision with root package name */
    public String f13493h;

    public String getUrl() {
        return this.f13492g;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f13490e = jSONObject.optInt("props_id");
        this.f13491f = jSONObject.optInt("end_time", 0);
        this.f13492g = jSONObject.optString(this.f13492g, "");
        this.f13493h = jSONObject.optString("expire_remind");
    }

    public int s() {
        return this.f13491f;
    }

    public String t() {
        return this.f13493h;
    }

    public int u() {
        return this.f13490e;
    }

    public void v(PayMemberInfo payMemberInfo) {
        if (payMemberInfo == null) {
            return;
        }
        Integer num = payMemberInfo.props_id;
        if (num != null) {
            this.f13490e = num.intValue();
        }
        Integer num2 = payMemberInfo.end_time;
        if (num2 != null) {
            this.f13491f = num2.intValue();
        }
        this.f13492g = payMemberInfo.url;
        this.f13493h = payMemberInfo.expire_remind;
    }

    public void w(String str) {
        this.f13493h = str;
    }
}
