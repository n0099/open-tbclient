package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes3.dex */
public class PayMemberInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f12717e;

    /* renamed from: f  reason: collision with root package name */
    public int f12718f;

    /* renamed from: g  reason: collision with root package name */
    public String f12719g;

    /* renamed from: h  reason: collision with root package name */
    public String f12720h;

    public String getUrl() {
        return this.f12719g;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f12717e = jSONObject.optInt("props_id");
        this.f12718f = jSONObject.optInt("end_time", 0);
        this.f12719g = jSONObject.optString(this.f12719g, "");
        this.f12720h = jSONObject.optString("expire_remind");
    }

    public int s() {
        return this.f12718f;
    }

    public String t() {
        return this.f12720h;
    }

    public int u() {
        return this.f12717e;
    }

    public void v(PayMemberInfo payMemberInfo) {
        if (payMemberInfo == null) {
            return;
        }
        Integer num = payMemberInfo.props_id;
        if (num != null) {
            this.f12717e = num.intValue();
        }
        Integer num2 = payMemberInfo.end_time;
        if (num2 != null) {
            this.f12718f = num2.intValue();
        }
        this.f12719g = payMemberInfo.url;
        this.f12720h = payMemberInfo.expire_remind;
    }

    public void w(String str) {
        this.f12720h = str;
    }
}
