package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p {
    public String hNG;
    public String hNH;
    public String hNI;
    public String hNJ;
    public String hNK;
    public String hNL;
    public String hNM;
    public String hNN;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hNG = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.hNH = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.hNI = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.hNJ = jSONObject.optString("follow_status");
            this.hNL = jSONObject.optString("follow_count");
            this.hNK = jSONObject.optString("fans_count");
            this.hNM = jSONObject.optString("live_count");
            this.hNN = jSONObject.optString("record_count");
        }
    }
}
