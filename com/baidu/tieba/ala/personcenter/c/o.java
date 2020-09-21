package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    public String gXA;
    public String gXB;
    public String gXC;
    public String gXD;
    public String gXE;
    public String gXx;
    public String gXy;
    public String gXz;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gXx = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.gXy = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.gXz = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.gXA = jSONObject.optString("follow_status");
            this.gXC = jSONObject.optString("follow_count");
            this.gXB = jSONObject.optString("fans_count");
            this.gXD = jSONObject.optString("live_count");
            this.gXE = jSONObject.optString("record_count");
        }
    }
}
