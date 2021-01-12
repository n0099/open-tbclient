package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class i {
    public int gEi;
    public int gEj;
    public int gEk;
    public int gEl;
    public int gEm;
    public boolean gEn;
    public int gEo;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.gEi = jSONObject.optInt("sign_time");
            this.gEj = jSONObject.optInt("cont_sign_num");
            this.gEk = jSONObject.optInt("cout_total_sign_num");
            this.gEl = jSONObject.optInt("total_resign_num");
            this.gEm = jSONObject.optInt("miss_sign_num");
            this.gEn = jSONObject.optInt("is_sign_in") == 1;
            this.gEo = jSONObject.optInt("user_sign_rank");
        }
    }
}
