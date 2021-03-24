package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f13820e;

    /* renamed from: f  reason: collision with root package name */
    public int f13821f;

    /* renamed from: g  reason: collision with root package name */
    public String f13822g;

    /* renamed from: h  reason: collision with root package name */
    public String f13823h;

    public String getUrl() {
        return this.f13822g;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f13820e = jSONObject.optInt("props_id");
        this.f13821f = jSONObject.optInt("end_time", 0);
        this.f13822g = jSONObject.optString(this.f13822g, "");
        this.f13823h = jSONObject.optString("expire_remind");
    }

    public int s() {
        return this.f13821f;
    }

    public String t() {
        return this.f13823h;
    }

    public int u() {
        return this.f13820e;
    }

    public void v(PayMemberInfo payMemberInfo) {
        if (payMemberInfo == null) {
            return;
        }
        Integer num = payMemberInfo.props_id;
        if (num != null) {
            this.f13820e = num.intValue();
        }
        Integer num2 = payMemberInfo.end_time;
        if (num2 != null) {
            this.f13821f = num2.intValue();
        }
        this.f13822g = payMemberInfo.url;
        this.f13823h = payMemberInfo.expire_remind;
    }

    public void w(String str) {
        this.f13823h = str;
    }
}
