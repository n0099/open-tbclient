package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class e {
    private int Ud;
    private int arT;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.arT = jSONObject.optInt("props_id");
            this.Ud = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.arT = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Ud = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int Ca() {
        return this.arT;
    }

    public int rF() {
        return this.Ud;
    }

    public String getUrl() {
        return this.url;
    }

    public String Cb() {
        return this.expire_remind;
    }

    public void eR(String str) {
        this.expire_remind = str;
    }
}
