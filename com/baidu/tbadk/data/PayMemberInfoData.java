package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int Ug;
    private int aAS;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAS = jSONObject.optInt("props_id");
            this.Ug = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.aAS = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Ug = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int Cv() {
        return this.aAS;
    }

    public int pr() {
        return this.Ug;
    }

    public String getUrl() {
        return this.url;
    }

    public String Cw() {
        return this.expire_remind;
    }

    public void fy(String str) {
        this.expire_remind = str;
    }
}
