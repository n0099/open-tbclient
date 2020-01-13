package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l {
    public String frQ;
    public String frR;
    public String frS;
    public String frT;
    public String frU;
    public String frV;
    public String frW;
    public String frX;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.frQ = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.frR = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.frS = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.frT = jSONObject.optString("follow_status");
            this.frV = jSONObject.optString("follow_count");
            this.frU = jSONObject.optString("fans_count");
            this.frW = jSONObject.optString("live_count");
            this.frX = jSONObject.optString("record_count");
        }
    }
}
