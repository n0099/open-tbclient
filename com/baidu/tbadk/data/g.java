package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.PayActivityConfig;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class g {
    private int OO;
    private int ahc;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ahc = jSONObject.optInt(PayActivityConfig.PROPS_ID);
            this.OO = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.ahc = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.OO = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int xU() {
        return this.ahc;
    }

    public int pM() {
        return this.OO;
    }

    public String getUrl() {
        return this.url;
    }

    public String xV() {
        return this.expire_remind;
    }

    public void dW(String str) {
        this.expire_remind = str;
    }
}
