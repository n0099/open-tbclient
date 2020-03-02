package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class l {
    public String fuA;
    public String fut;
    public String fuu;
    public String fuv;
    public String fuw;
    public String fux;
    public String fuy;
    public String fuz;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fut = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.fuu = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.fuv = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.fuw = jSONObject.optString("follow_status");
            this.fuy = jSONObject.optString("follow_count");
            this.fux = jSONObject.optString("fans_count");
            this.fuz = jSONObject.optString("live_count");
            this.fuA = jSONObject.optString("record_count");
        }
    }
}
