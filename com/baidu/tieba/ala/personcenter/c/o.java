package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {
    public String fZS;
    public String fZT;
    public String fZU;
    public String fZV;
    public String fZW;
    public String fZX;
    public String fZY;
    public String fZZ;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fZS = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.fZT = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.fZU = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.fZV = jSONObject.optString("follow_status");
            this.fZX = jSONObject.optString("follow_count");
            this.fZW = jSONObject.optString("fans_count");
            this.fZY = jSONObject.optString("live_count");
            this.fZZ = jSONObject.optString("record_count");
        }
    }
}
