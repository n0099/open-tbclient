package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int aKU;
    private int adu;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKU = jSONObject.optInt("props_id");
            this.adu = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.aKU = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.adu = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int GX() {
        return this.aKU;
    }

    public int tQ() {
        return this.adu;
    }

    public String getUrl() {
        return this.url;
    }

    public String GY() {
        return this.expire_remind;
    }

    public void gq(String str) {
        this.expire_remind = str;
    }
}
