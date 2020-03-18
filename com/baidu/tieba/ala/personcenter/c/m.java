package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m {
    public String fvm;
    public String fvn;
    public String fvo;
    public String fvp;
    public String fvq;
    public String fvr;
    public String fvs;
    public String fvt;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fvm = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.fvn = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.fvo = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.fvp = jSONObject.optString("follow_status");
            this.fvr = jSONObject.optString("follow_count");
            this.fvq = jSONObject.optString("fans_count");
            this.fvs = jSONObject.optString("live_count");
            this.fvt = jSONObject.optString("record_count");
        }
    }
}
