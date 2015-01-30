package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.PayActivityConfig;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class g {
    private int Dj;
    private int WZ;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.WZ = jSONObject.optInt(PayActivityConfig.PROPS_ID);
            this.Dj = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.WZ = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Dj = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int uK() {
        return this.WZ;
    }

    public int ms() {
        return this.Dj;
    }

    public String getUrl() {
        return this.url;
    }

    public String uL() {
        return this.expire_remind;
    }

    public void dQ(String str) {
        this.expire_remind = str;
    }
}
