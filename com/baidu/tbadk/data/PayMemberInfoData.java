package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int bvX;
    private int chi;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.chi = jSONObject.optInt("props_id");
            this.bvX = jSONObject.optInt("end_time", 0);
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
                this.bvX = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int alq() {
        return this.chi;
    }

    public int WX() {
        return this.bvX;
    }

    public String getUrl() {
        return this.url;
    }

    public String alr() {
        return this.expire_remind;
    }

    public void ov(String str) {
        this.expire_remind = str;
    }
}
