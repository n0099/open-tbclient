package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int dzP;
    private String expire_remind;
    private int props_id;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.props_id = jSONObject.optInt("props_id");
            this.dzP = jSONObject.optInt("end_time", 0);
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
                this.dzP = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int bcu() {
        return this.props_id;
    }

    public int aOv() {
        return this.dzP;
    }

    public String getUrl() {
        return this.url;
    }

    public String bcv() {
        return this.expire_remind;
    }

    public void xO(String str) {
        this.expire_remind = str;
    }
}
