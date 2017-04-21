package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class h {
    private int Tp;
    private int axO;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axO = jSONObject.optInt("props_id");
            this.Tp = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.axO = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Tp = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int CG() {
        return this.axO;
    }

    public int pH() {
        return this.Tp;
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
