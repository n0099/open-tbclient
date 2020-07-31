package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    public String gHj;
    public String gHk;
    public String gHl;
    public String gHm;
    public String gHn;
    public String gHo;
    public String gHp;
    public String gHq;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gHj = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.gHk = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.gHl = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.gHm = jSONObject.optString("follow_status");
            this.gHo = jSONObject.optString("follow_count");
            this.gHn = jSONObject.optString("fans_count");
            this.gHp = jSONObject.optString("live_count");
            this.gHq = jSONObject.optString("record_count");
        }
    }
}
