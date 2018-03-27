package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int aJO;
    private int brc;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.brc = jSONObject.optInt("props_id");
            this.aJO = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.brc = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.aJO = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int Ky() {
        return this.brc;
    }

    public int xG() {
        return this.aJO;
    }

    public String getUrl() {
        return this.url;
    }

    public String Kz() {
        return this.expire_remind;
    }

    public void fX(String str) {
        this.expire_remind = str;
    }
}
