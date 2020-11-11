package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p {
    public String hEq;
    public String hEr;
    public String hEs;
    public String hEt;
    public String hEu;
    public String hEv;
    public String hEw;
    public String hEx;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hEq = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.hEr = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.hEs = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.hEt = jSONObject.optString("follow_status");
            this.hEv = jSONObject.optString("follow_count");
            this.hEu = jSONObject.optString("fans_count");
            this.hEw = jSONObject.optString("live_count");
            this.hEx = jSONObject.optString("record_count");
        }
    }
}
