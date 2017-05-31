package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class h {
    private int Sv;
    private int axx;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axx = jSONObject.optInt("props_id");
            this.Sv = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.axx = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Sv = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int BG() {
        return this.axx;
    }

    public int pg() {
        return this.Sv;
    }

    public String getUrl() {
        return this.url;
    }

    public String BH() {
        return this.expire_remind;
    }

    public void eQ(String str) {
        this.expire_remind = str;
    }
}
