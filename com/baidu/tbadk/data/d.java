package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.BusinessAccountInfo;
/* loaded from: classes.dex */
public class d {
    public boolean fxB;
    public String fxC;
    public String fxD;
    public boolean isForumBusinessAccount;

    public void a(BusinessAccountInfo businessAccountInfo) {
        if (businessAccountInfo != null) {
            this.fxB = businessAccountInfo.is_business_account.intValue() == 1;
            this.isForumBusinessAccount = businessAccountInfo.is_forum_business_account.intValue() == 1;
            this.fxC = businessAccountInfo.business_name;
            this.fxD = businessAccountInfo.identifi_explain;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fxB = jSONObject.optInt("is_business_account") == 1;
            this.isForumBusinessAccount = jSONObject.optInt("is_forum_business_account") == 1;
            this.fxC = jSONObject.optString("business_name");
            this.fxD = jSONObject.optString("identifi_explain");
        }
    }
}
