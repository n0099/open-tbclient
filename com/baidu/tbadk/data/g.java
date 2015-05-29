package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.PayActivityConfig;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class g {
    private int Pl;
    private int ail;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ail = jSONObject.optInt(PayActivityConfig.PROPS_ID);
            this.Pl = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.ail = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Pl = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int yN() {
        return this.ail;
    }

    public int qs() {
        return this.Pl;
    }

    public String getUrl() {
        return this.url;
    }

    public String yO() {
        return this.expire_remind;
    }

    public void eq(String str) {
        this.expire_remind = str;
    }
}
