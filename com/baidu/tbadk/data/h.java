package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class h {
    private int Tn;
    private int axM;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axM = jSONObject.optInt("props_id");
            this.Tn = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.axM = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Tn = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int CG() {
        return this.axM;
    }

    public int pH() {
        return this.Tn;
    }

    public String getUrl() {
        return this.url;
    }

    public String CH() {
        return this.expire_remind;
    }

    public void eV(String str) {
        this.expire_remind = str;
    }
}
