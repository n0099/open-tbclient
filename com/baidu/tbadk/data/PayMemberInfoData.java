package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int aJX;
    private int adf;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJX = jSONObject.optInt("props_id");
            this.adf = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.aJX = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.adf = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int GF() {
        return this.aJX;
    }

    public int tK() {
        return this.adf;
    }

    public String getUrl() {
        return this.url;
    }

    public String GG() {
        return this.expire_remind;
    }

    public void gm(String str) {
        this.expire_remind = str;
    }
}
