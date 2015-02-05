package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.PayActivityConfig;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class g {
    private int Dg;
    private int WW;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.WW = jSONObject.optInt(PayActivityConfig.PROPS_ID);
            this.Dg = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.WW = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Dg = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int uE() {
        return this.WW;
    }

    public int ml() {
        return this.Dg;
    }

    public String getUrl() {
        return this.url;
    }

    public String uF() {
        return this.expire_remind;
    }

    public void dN(String str) {
        this.expire_remind = str;
    }
}
