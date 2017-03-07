package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class h {
    private int SV;
    private int axw;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axw = jSONObject.optInt("props_id");
            this.SV = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.axw = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.SV = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int Ci() {
        return this.axw;
    }

    public int pj() {
        return this.SV;
    }

    public String getUrl() {
        return this.url;
    }

    public String Cj() {
        return this.expire_remind;
    }

    public void eP(String str) {
        this.expire_remind = str;
    }
}
