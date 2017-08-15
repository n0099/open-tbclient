package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int Uf;
    private int aAR;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAR = jSONObject.optInt("props_id");
            this.Uf = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.aAR = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Uf = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int Cv() {
        return this.aAR;
    }

    public int pq() {
        return this.Uf;
    }

    public String getUrl() {
        return this.url;
    }

    public String Cw() {
        return this.expire_remind;
    }

    public void fu(String str) {
        this.expire_remind = str;
    }
}
