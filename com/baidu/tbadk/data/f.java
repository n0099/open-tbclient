package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class f {
    private int Rz;
    private int asn;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.asn = jSONObject.optInt("props_id");
            this.Rz = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.asn = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Rz = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int CF() {
        return this.asn;
    }

    public int qW() {
        return this.Rz;
    }

    public String getUrl() {
        return this.url;
    }

    public String CG() {
        return this.expire_remind;
    }

    public void eY(String str) {
        this.expire_remind = str;
    }
}
