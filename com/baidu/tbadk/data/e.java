package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class e {
    private int Ue;
    private int apx;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.apx = jSONObject.optInt("props_id");
            this.Ue = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.apx = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Ue = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int AU() {
        return this.apx;
    }

    public int rz() {
        return this.Ue;
    }

    public String getUrl() {
        return this.url;
    }

    public String AV() {
        return this.expire_remind;
    }

    public void eP(String str) {
        this.expire_remind = str;
    }
}
