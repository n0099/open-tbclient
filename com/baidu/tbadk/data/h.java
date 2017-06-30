package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class h {
    private int Sq;
    private int ayz;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ayz = jSONObject.optInt("props_id");
            this.Sq = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.ayz = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Sq = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int Cb() {
        return this.ayz;
    }

    public int pd() {
        return this.Sq;
    }

    public String getUrl() {
        return this.url;
    }

    public String Cc() {
        return this.expire_remind;
    }

    public void fk(String str) {
        this.expire_remind = str;
    }
}
