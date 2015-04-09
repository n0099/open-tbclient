package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.PayActivityConfig;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class g {
    private int OQ;
    private int ahk;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ahk = jSONObject.optInt(PayActivityConfig.PROPS_ID);
            this.OQ = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.ahk = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.OQ = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int ya() {
        return this.ahk;
    }

    public int pM() {
        return this.OQ;
    }

    public String getUrl() {
        return this.url;
    }

    public String yb() {
        return this.expire_remind;
    }

    public void dZ(String str) {
        this.expire_remind = str;
    }
}
