package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int bvZ;
    private int chi;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.chi = jSONObject.optInt("props_id");
            this.bvZ = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.chi = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.bvZ = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int alp() {
        return this.chi;
    }

    public int WX() {
        return this.bvZ;
    }

    public String getUrl() {
        return this.url;
    }

    public String alq() {
        return this.expire_remind;
    }

    public void ov(String str) {
        this.expire_remind = str;
    }
}
