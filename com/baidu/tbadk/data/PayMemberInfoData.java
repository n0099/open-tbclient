package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int aXO;
    private int apo;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aXO = jSONObject.optInt("props_id");
            this.apo = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.aXO = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.apo = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int LO() {
        return this.aXO;
    }

    public int ym() {
        return this.apo;
    }

    public String getUrl() {
        return this.url;
    }

    public String LP() {
        return this.expire_remind;
    }

    public void hH(String str) {
        this.expire_remind = str;
    }
}
