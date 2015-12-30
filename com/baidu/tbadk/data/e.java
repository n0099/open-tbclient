package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class e {
    private int UE;
    private int ara;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ara = jSONObject.optInt("props_id");
            this.UE = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.ara = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.UE = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int AK() {
        return this.ara;
    }

    public int ri() {
        return this.UE;
    }

    public String getUrl() {
        return this.url;
    }

    public String AL() {
        return this.expire_remind;
    }

    public void eS(String str) {
        this.expire_remind = str;
    }
}
