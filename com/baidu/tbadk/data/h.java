package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class h {
    private int NR;
    private int asb;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.asb = jSONObject.optInt("props_id");
            this.NR = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.asb = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.NR = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int BP() {
        return this.asb;
    }

    public int oV() {
        return this.NR;
    }

    public String getUrl() {
        return this.url;
    }

    public String BQ() {
        return this.expire_remind;
    }

    public void fa(String str) {
        this.expire_remind = str;
    }
}
