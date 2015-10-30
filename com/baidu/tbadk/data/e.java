package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class e {
    private int TM;
    private int anD;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.anD = jSONObject.optInt("props_id");
            this.TM = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.anD = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.TM = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int zT() {
        return this.anD;
    }

    public int rk() {
        return this.TM;
    }

    public String getUrl() {
        return this.url;
    }

    public String zU() {
        return this.expire_remind;
    }

    public void eF(String str) {
        this.expire_remind = str;
    }
}
