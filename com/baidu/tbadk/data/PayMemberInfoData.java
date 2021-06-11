package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes3.dex */
public class PayMemberInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f12782e;

    /* renamed from: f  reason: collision with root package name */
    public int f12783f;

    /* renamed from: g  reason: collision with root package name */
    public String f12784g;

    /* renamed from: h  reason: collision with root package name */
    public String f12785h;

    public void A(String str) {
        this.f12785h = str;
    }

    public String getUrl() {
        return this.f12784g;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f12782e = jSONObject.optInt("props_id");
        this.f12783f = jSONObject.optInt(ResultTB.ENDTIME, 0);
        this.f12784g = jSONObject.optString(this.f12784g, "");
        this.f12785h = jSONObject.optString("expire_remind");
    }

    public int w() {
        return this.f12783f;
    }

    public String x() {
        return this.f12785h;
    }

    public int y() {
        return this.f12782e;
    }

    public void z(PayMemberInfo payMemberInfo) {
        if (payMemberInfo == null) {
            return;
        }
        Integer num = payMemberInfo.props_id;
        if (num != null) {
            this.f12782e = num.intValue();
        }
        Integer num2 = payMemberInfo.end_time;
        if (num2 != null) {
            this.f12783f = num2.intValue();
        }
        this.f12784g = payMemberInfo.url;
        this.f12785h = payMemberInfo.expire_remind;
    }
}
