package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int TC;
    private int aAb;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAb = jSONObject.optInt("props_id");
            this.TC = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.aAb = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.TC = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int Co() {
        return this.aAb;
    }

    public int pl() {
        return this.TC;
    }

    public String getUrl() {
        return this.url;
    }

    public String Cp() {
        return this.expire_remind;
    }

    public void ft(String str) {
        this.expire_remind = str;
    }
}
