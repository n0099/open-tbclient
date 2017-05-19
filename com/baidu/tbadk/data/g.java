package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class g {
    private int SI;
    private int axL;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axL = jSONObject.optInt("props_id");
            this.SI = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.axL = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.SI = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int BN() {
        return this.axL;
    }

    public int po() {
        return this.SI;
    }

    public String getUrl() {
        return this.url;
    }

    public String BO() {
        return this.expire_remind;
    }

    public void eS(String str) {
        this.expire_remind = str;
    }
}
