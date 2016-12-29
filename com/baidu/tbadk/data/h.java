package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class h {
    private int OD;
    private int asW;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.asW = jSONObject.optInt("props_id");
            this.OD = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.asW = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.OD = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int BU() {
        return this.asW;
    }

    public int pc() {
        return this.OD;
    }

    public String getUrl() {
        return this.url;
    }

    public String BV() {
        return this.expire_remind;
    }

    public void fd(String str) {
        this.expire_remind = str;
    }
}
