package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    public String gTM;
    public String gTN;
    public String gTO;
    public String gTP;
    public String gTQ;
    public String gTR;
    public String gTS;
    public String gTT;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gTM = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.gTN = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.gTO = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.gTP = jSONObject.optString("follow_status");
            this.gTR = jSONObject.optString("follow_count");
            this.gTQ = jSONObject.optString("fans_count");
            this.gTS = jSONObject.optString("live_count");
            this.gTT = jSONObject.optString("record_count");
        }
    }
}
