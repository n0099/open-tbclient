package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p {
    public String hNE;
    public String hNF;
    public String hNG;
    public String hNH;
    public String hNI;
    public String hNJ;
    public String hNK;
    public String hNL;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hNE = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.hNF = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.hNG = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.hNH = jSONObject.optString("follow_status");
            this.hNJ = jSONObject.optString("follow_count");
            this.hNI = jSONObject.optString("fans_count");
            this.hNK = jSONObject.optString("live_count");
            this.hNL = jSONObject.optString("record_count");
        }
    }
}
