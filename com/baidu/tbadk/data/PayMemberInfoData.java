package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes3.dex */
public class PayMemberInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f13473e;

    /* renamed from: f  reason: collision with root package name */
    public int f13474f;

    /* renamed from: g  reason: collision with root package name */
    public String f13475g;

    /* renamed from: h  reason: collision with root package name */
    public String f13476h;

    public String getUrl() {
        return this.f13475g;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f13473e = jSONObject.optInt("props_id");
        this.f13474f = jSONObject.optInt("end_time", 0);
        this.f13475g = jSONObject.optString(this.f13475g, "");
        this.f13476h = jSONObject.optString("expire_remind");
    }

    public int s() {
        return this.f13474f;
    }

    public String t() {
        return this.f13476h;
    }

    public int u() {
        return this.f13473e;
    }

    public void v(PayMemberInfo payMemberInfo) {
        if (payMemberInfo == null) {
            return;
        }
        Integer num = payMemberInfo.props_id;
        if (num != null) {
            this.f13473e = num.intValue();
        }
        Integer num2 = payMemberInfo.end_time;
        if (num2 != null) {
            this.f13474f = num2.intValue();
        }
        this.f13475g = payMemberInfo.url;
        this.f13476h = payMemberInfo.expire_remind;
    }

    public void w(String str) {
        this.f13476h = str;
    }
}
