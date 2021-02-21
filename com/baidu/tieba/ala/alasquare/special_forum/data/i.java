package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class i {
    public int gHg;
    public int gHh;
    public int gHi;
    public int gHj;
    public int gHk;
    public boolean gHl;
    public int gHm;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.gHg = jSONObject.optInt("sign_time");
            this.gHh = jSONObject.optInt("cont_sign_num");
            this.gHi = jSONObject.optInt("cout_total_sign_num");
            this.gHj = jSONObject.optInt("total_resign_num");
            this.gHk = jSONObject.optInt("miss_sign_num");
            this.gHl = jSONObject.optInt("is_sign_in") == 1;
            this.gHm = jSONObject.optInt("user_sign_rank");
        }
    }
}
