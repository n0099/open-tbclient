package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int Uk;
    private int aAC;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAC = jSONObject.optInt("props_id");
            this.Uk = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.aAC = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Uk = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int Cy() {
        return this.aAC;
    }

    public int ps() {
        return this.Uk;
    }

    public String getUrl() {
        return this.url;
    }

    public String Cz() {
        return this.expire_remind;
    }

    public void fz(String str) {
        this.expire_remind = str;
    }
}
