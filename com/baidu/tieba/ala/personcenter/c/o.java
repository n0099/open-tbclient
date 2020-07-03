package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {
    public String gBM;
    public String gBN;
    public String gBO;
    public String gBP;
    public String gBQ;
    public String gBR;
    public String gBS;
    public String gBT;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gBM = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.gBN = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.gBO = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.gBP = jSONObject.optString("follow_status");
            this.gBR = jSONObject.optString("follow_count");
            this.gBQ = jSONObject.optString("fans_count");
            this.gBS = jSONObject.optString("live_count");
            this.gBT = jSONObject.optString("record_count");
        }
    }
}
