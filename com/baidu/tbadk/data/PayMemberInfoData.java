package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int crI;
    private int end_time;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.crI = jSONObject.optInt("props_id");
            this.end_time = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.crI = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.end_time = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int arI() {
        return this.crI;
    }

    public int acI() {
        return this.end_time;
    }

    public String getUrl() {
        return this.url;
    }

    public String arJ() {
        return this.expire_remind;
    }

    public void qf(String str) {
        this.expire_remind = str;
    }
}
