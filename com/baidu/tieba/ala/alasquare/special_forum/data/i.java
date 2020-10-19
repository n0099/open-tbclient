package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    public int gab;
    public int gac;
    public int gad;
    public int gae;
    public int gaf;
    public boolean gag;
    public int gah;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.gab = jSONObject.optInt("sign_time");
            this.gac = jSONObject.optInt("cont_sign_num");
            this.gad = jSONObject.optInt("cout_total_sign_num");
            this.gae = jSONObject.optInt("total_resign_num");
            this.gaf = jSONObject.optInt("miss_sign_num");
            this.gag = jSONObject.optInt("is_sign_in") == 1;
            this.gah = jSONObject.optInt("user_sign_rank");
        }
    }
}
