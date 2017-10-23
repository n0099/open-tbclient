package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int Tk;
    private int azi;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.azi = jSONObject.optInt("props_id");
            this.Tk = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.azi = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Tk = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int BN() {
        return this.azi;
    }

    public int pf() {
        return this.Tk;
    }

    public String getUrl() {
        return this.url;
    }

    public String BO() {
        return this.expire_remind;
    }

    public void fl(String str) {
        this.expire_remind = str;
    }
}
