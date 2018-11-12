package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int aTF;
    private int alj;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aTF = jSONObject.optInt("props_id");
            this.alj = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.aTF = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.alj = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int Ku() {
        return this.aTF;
    }

    public int wV() {
        return this.alj;
    }

    public String getUrl() {
        return this.url;
    }

    public String Kv() {
        return this.expire_remind;
    }

    public void ha(String str) {
        this.expire_remind = str;
    }
}
