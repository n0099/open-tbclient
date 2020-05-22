package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {
    public String goM;
    public String goN;
    public String goO;
    public String goP;
    public String goQ;
    public String goR;
    public String goS;
    public String goT;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.goM = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.goN = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.goO = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.goP = jSONObject.optString("follow_status");
            this.goR = jSONObject.optString("follow_count");
            this.goQ = jSONObject.optString("fans_count");
            this.goS = jSONObject.optString("live_count");
            this.goT = jSONObject.optString("record_count");
        }
    }
}
