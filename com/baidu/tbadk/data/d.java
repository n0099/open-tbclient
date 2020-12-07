package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.BusinessAccountInfo;
/* loaded from: classes.dex */
public class d {
    public boolean fsE;
    public String fsF;
    public String fsG;
    public boolean isForumBusinessAccount;

    public void a(BusinessAccountInfo businessAccountInfo) {
        if (businessAccountInfo != null) {
            this.fsE = businessAccountInfo.is_business_account.intValue() == 1;
            this.isForumBusinessAccount = businessAccountInfo.is_forum_business_account.intValue() == 1;
            this.fsF = businessAccountInfo.business_name;
            this.fsG = businessAccountInfo.identifi_explain;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fsE = jSONObject.optInt("is_business_account") == 1;
            this.isForumBusinessAccount = jSONObject.optInt("is_forum_business_account") == 1;
            this.fsF = jSONObject.optString("business_name");
            this.fsG = jSONObject.optString("identifi_explain");
        }
    }
}
