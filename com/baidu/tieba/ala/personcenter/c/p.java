package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p {
    public String hmA;
    public String hmB;
    public String hmC;
    public String hmD;
    public String hmE;
    public String hmF;
    public String hmy;
    public String hmz;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hmy = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.hmz = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.hmA = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.hmB = jSONObject.optString("follow_status");
            this.hmD = jSONObject.optString("follow_count");
            this.hmC = jSONObject.optString("fans_count");
            this.hmE = jSONObject.optString("live_count");
            this.hmF = jSONObject.optString("record_count");
        }
    }
}
