package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class h {
    private int OE;
    private int asz;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.asz = jSONObject.optInt("props_id");
            this.OE = jSONObject.optInt(ThActivityDetailActivityConfig.END_TIME, 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.asz = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.OE = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int Cb() {
        return this.asz;
    }

    public int pa() {
        return this.OE;
    }

    public String getUrl() {
        return this.url;
    }

    public String Cc() {
        return this.expire_remind;
    }

    public void ff(String str) {
        this.expire_remind = str;
    }
}
