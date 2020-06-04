package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {
    public String goX;
    public String goY;
    public String goZ;
    public String gpa;
    public String gpb;
    public String gpc;
    public String gpd;
    public String gpe;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.goX = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.goY = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.goZ = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.gpa = jSONObject.optString("follow_status");
            this.gpc = jSONObject.optString("follow_count");
            this.gpb = jSONObject.optString("fans_count");
            this.gpd = jSONObject.optString("live_count");
            this.gpe = jSONObject.optString("record_count");
        }
    }
}
