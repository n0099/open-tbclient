package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.BusinessAccountInfo;
/* loaded from: classes.dex */
public class d {
    public boolean fBq;
    public String fBr;
    public String fBs;
    public boolean isForumBusinessAccount;

    public void a(BusinessAccountInfo businessAccountInfo) {
        if (businessAccountInfo != null) {
            this.fBq = businessAccountInfo.is_business_account.intValue() == 1;
            this.isForumBusinessAccount = businessAccountInfo.is_forum_business_account.intValue() == 1;
            this.fBr = businessAccountInfo.business_name;
            this.fBs = businessAccountInfo.identifi_explain;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fBq = jSONObject.optInt("is_business_account") == 1;
            this.isForumBusinessAccount = jSONObject.optInt("is_forum_business_account") == 1;
            this.fBr = jSONObject.optString("business_name");
            this.fBs = jSONObject.optString("identifi_explain");
        }
    }
}
