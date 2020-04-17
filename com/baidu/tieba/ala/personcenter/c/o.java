package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {
    public String fZN;
    public String fZO;
    public String fZP;
    public String fZQ;
    public String fZR;
    public String fZS;
    public String fZT;
    public String fZU;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fZN = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.fZO = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.fZP = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.fZQ = jSONObject.optString("follow_status");
            this.fZS = jSONObject.optString("follow_count");
            this.fZR = jSONObject.optString("fans_count");
            this.fZT = jSONObject.optString("live_count");
            this.fZU = jSONObject.optString("record_count");
        }
    }
}
