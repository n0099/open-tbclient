package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int bwd;
    private int chl;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.chl = jSONObject.optInt("props_id");
            this.bwd = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.chl = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.bwd = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int alm() {
        return this.chl;
    }

    public int WU() {
        return this.bwd;
    }

    public String getUrl() {
        return this.url;
    }

    public String aln() {
        return this.expire_remind;
    }

    public void ow(String str) {
        this.expire_remind = str;
    }
}
