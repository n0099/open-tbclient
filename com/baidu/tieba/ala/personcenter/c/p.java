package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class p {
    public String aLW;
    public String iac;
    public String iad;
    public String iae;
    public String iaf;
    public String iag;
    public String iah;
    public String iai;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.iac = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.iad = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.iae = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.aLW = jSONObject.optString("follow_status");
            this.iag = jSONObject.optString("follow_count");
            this.iaf = jSONObject.optString("fans_count");
            this.iah = jSONObject.optString("live_count");
            this.iai = jSONObject.optString("record_count");
        }
    }
}
