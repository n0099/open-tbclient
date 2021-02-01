package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.BusinessAccountInfo;
/* loaded from: classes.dex */
public class d {
    public boolean fzR;
    public String fzS;
    public String fzT;
    public boolean isForumBusinessAccount;

    public void a(BusinessAccountInfo businessAccountInfo) {
        if (businessAccountInfo != null) {
            this.fzR = businessAccountInfo.is_business_account.intValue() == 1;
            this.isForumBusinessAccount = businessAccountInfo.is_forum_business_account.intValue() == 1;
            this.fzS = businessAccountInfo.business_name;
            this.fzT = businessAccountInfo.identifi_explain;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fzR = jSONObject.optInt("is_business_account") == 1;
            this.isForumBusinessAccount = jSONObject.optInt("is_forum_business_account") == 1;
            this.fzS = jSONObject.optString("business_name");
            this.fzT = jSONObject.optString("identifi_explain");
        }
    }
}
