package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int Vj;
    private int aBB;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aBB = jSONObject.optInt("props_id");
            this.Vj = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.aBB = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Vj = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int De() {
        return this.aBB;
    }

    public int qp() {
        return this.Vj;
    }

    public String getUrl() {
        return this.url;
    }

    public String Df() {
        return this.expire_remind;
    }

    public void fO(String str) {
        this.expire_remind = str;
    }
}
