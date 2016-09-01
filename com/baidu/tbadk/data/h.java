package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class h {
    private int OD;
    private int asO;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.asO = jSONObject.optInt("props_id");
            this.OD = jSONObject.optInt(ThActivityDetailActivityConfig.END_TIME, 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.asO = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.OD = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int BY() {
        return this.asO;
    }

    public int oZ() {
        return this.OD;
    }

    public String getUrl() {
        return this.url;
    }

    public String BZ() {
        return this.expire_remind;
    }

    public void fc(String str) {
        this.expire_remind = str;
    }
}
