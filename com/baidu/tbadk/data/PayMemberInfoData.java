package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int SF;
    private int azz;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.azz = jSONObject.optInt("props_id");
            this.SF = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.azz = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.SF = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int Cn() {
        return this.azz;
    }

    public int pg() {
        return this.SF;
    }

    public String getUrl() {
        return this.url;
    }

    public String Co() {
        return this.expire_remind;
    }

    public void fo(String str) {
        this.expire_remind = str;
    }
}
