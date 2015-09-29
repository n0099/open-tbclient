package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class e {
    private int TL;
    private int anC;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.anC = jSONObject.optInt("props_id");
            this.TL = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.anC = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.TL = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int zW() {
        return this.anC;
    }

    public int rn() {
        return this.TL;
    }

    public String getUrl() {
        return this.url;
    }

    public String zX() {
        return this.expire_remind;
    }

    public void eF(String str) {
        this.expire_remind = str;
    }
}
