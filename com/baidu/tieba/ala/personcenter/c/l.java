package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l {
    public String foG;
    public String foH;
    public String foI;
    public String foJ;
    public String foK;
    public String foL;
    public String foM;
    public String foN;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.foG = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.foH = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.foI = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.foJ = jSONObject.optString("follow_status");
            this.foL = jSONObject.optString("follow_count");
            this.foK = jSONObject.optString("fans_count");
            this.foM = jSONObject.optString("live_count");
            this.foN = jSONObject.optString("record_count");
        }
    }
}
