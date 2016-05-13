package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class g {
    private int Mp;
    private int aod;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aod = jSONObject.optInt("props_id");
            this.Mp = jSONObject.optInt(ThActivityDetailActivityConfig.END_TIME, 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.aod = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Mp = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int AA() {
        return this.aod;
    }

    public int ot() {
        return this.Mp;
    }

    public String getUrl() {
        return this.url;
    }

    public String AB() {
        return this.expire_remind;
    }

    public void eV(String str) {
        this.expire_remind = str;
    }
}
