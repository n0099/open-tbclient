package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p {
    public String hDX;
    public String hDY;
    public String hDZ;
    public String hEa;
    public String hEb;
    public String hEc;
    public String hEd;
    public String hEe;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hDX = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.hDY = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.hDZ = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.hEa = jSONObject.optString("follow_status");
            this.hEc = jSONObject.optString("follow_count");
            this.hEb = jSONObject.optString("fans_count");
            this.hEd = jSONObject.optString("live_count");
            this.hEe = jSONObject.optString("record_count");
        }
    }
}
