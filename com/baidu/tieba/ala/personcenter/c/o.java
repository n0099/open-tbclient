package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    public String gTQ;
    public String gTR;
    public String gTS;
    public String gTT;
    public String gTU;
    public String gTV;
    public String gTW;
    public String gTX;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gTQ = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.gTR = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.gTS = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.gTT = jSONObject.optString("follow_status");
            this.gTV = jSONObject.optString("follow_count");
            this.gTU = jSONObject.optString("fans_count");
            this.gTW = jSONObject.optString("live_count");
            this.gTX = jSONObject.optString("record_count");
        }
    }
}
