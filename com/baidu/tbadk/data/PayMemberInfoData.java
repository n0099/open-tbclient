package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int bDo;
    private int cps;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cps = jSONObject.optInt("props_id");
            this.bDo = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.cps = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.bDo = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int aqp() {
        return this.cps;
    }

    public int abB() {
        return this.bDo;
    }

    public String getUrl() {
        return this.url;
    }

    public String aqq() {
        return this.expire_remind;
    }

    public void pE(String str) {
        this.expire_remind = str;
    }
}
