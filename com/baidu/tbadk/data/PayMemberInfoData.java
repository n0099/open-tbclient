package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int aSD;
    private String expire_remind;
    private int props_id;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.props_id = jSONObject.optInt("props_id");
            this.aSD = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.props_id = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.aSD = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int byP() {
        return this.props_id;
    }

    public int bko() {
        return this.aSD;
    }

    public String getUrl() {
        return this.url;
    }

    public String byQ() {
        return this.expire_remind;
    }

    public void Dt(String str) {
        this.expire_remind = str;
    }
}
