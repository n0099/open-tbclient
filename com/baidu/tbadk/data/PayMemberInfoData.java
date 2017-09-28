package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes.dex */
public class PayMemberInfoData extends OrmObject {
    private int Tw;
    private int azu;
    private String expire_remind;
    private String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.azu = jSONObject.optInt("props_id");
            this.Tw = jSONObject.optInt("end_time", 0);
            this.url = jSONObject.optString(this.url, "");
            this.expire_remind = jSONObject.optString("expire_remind");
        }
    }

    public void a(PayMemberInfo payMemberInfo) {
        if (payMemberInfo != null) {
            if (payMemberInfo.props_id != null) {
                this.azu = payMemberInfo.props_id.intValue();
            }
            if (payMemberInfo.end_time != null) {
                this.Tw = payMemberInfo.end_time.intValue();
            }
            this.url = payMemberInfo.url;
            this.expire_remind = payMemberInfo.expire_remind;
        }
    }

    public int BT() {
        return this.azu;
    }

    public int pm() {
        return this.Tw;
    }

    public String getUrl() {
        return this.url;
    }

    public String BU() {
        return this.expire_remind;
    }

    public void fm(String str) {
        this.expire_remind = str;
    }
}
