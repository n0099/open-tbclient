package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class l {
    public String fus;
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
            this.fus = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.fut = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.fuu = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.fuv = jSONObject.optString("follow_status");
            this.fux = jSONObject.optString("follow_count");
            this.fuw = jSONObject.optString("fans_count");
            this.fuy = jSONObject.optString("live_count");
            this.fuz = jSONObject.optString("record_count");
        }
    }
}
