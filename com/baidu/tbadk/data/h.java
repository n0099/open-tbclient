package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class h {
    private int OH;
    private int att;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.att = jSONObject.optInt("props_id");
            this.OH = jSONObject.optInt(ThActivityDetailActivityConfig.END_TIME, 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.att = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.OH = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int Ch() {
        return this.att;
    }

    public int pc() {
        return this.OH;
    }

    public String getUrl() {
        return this.url;
    }

    public String Ci() {
        return this.expire_remind;
    }

    public void fh(String str) {
        this.expire_remind = str;
    }
}
