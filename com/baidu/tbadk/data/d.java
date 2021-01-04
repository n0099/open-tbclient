package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.BusinessAccountInfo;
/* loaded from: classes.dex */
public class d {
    public boolean fCj;
    public String fCk;
    public String fCl;
    public boolean isForumBusinessAccount;

    public void a(BusinessAccountInfo businessAccountInfo) {
        if (businessAccountInfo != null) {
            this.fCj = businessAccountInfo.is_business_account.intValue() == 1;
            this.isForumBusinessAccount = businessAccountInfo.is_forum_business_account.intValue() == 1;
            this.fCk = businessAccountInfo.business_name;
            this.fCl = businessAccountInfo.identifi_explain;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fCj = jSONObject.optInt("is_business_account") == 1;
            this.isForumBusinessAccount = jSONObject.optInt("is_forum_business_account") == 1;
            this.fCk = jSONObject.optString("business_name");
            this.fCl = jSONObject.optString("identifi_explain");
        }
    }
}
