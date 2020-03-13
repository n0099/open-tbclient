package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class l {
    public String fuG;
    public String fuH;
    public String fuI;
    public String fuJ;
    public String fuK;
    public String fuL;
    public String fuM;
    public String fuN;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fuG = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.fuH = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.fuI = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.fuJ = jSONObject.optString("follow_status");
            this.fuL = jSONObject.optString("follow_count");
            this.fuK = jSONObject.optString("fans_count");
            this.fuM = jSONObject.optString("live_count");
            this.fuN = jSONObject.optString("record_count");
        }
    }
}
