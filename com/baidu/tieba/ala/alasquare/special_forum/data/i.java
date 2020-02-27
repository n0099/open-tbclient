package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    public int erA;
    public int erB;
    public int erC;
    public int erD;
    public int erE;
    public boolean erF;
    public int erG;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.erA = jSONObject.optInt("sign_time");
            this.erB = jSONObject.optInt("cont_sign_num");
            this.erC = jSONObject.optInt("cout_total_sign_num");
            this.erD = jSONObject.optInt("total_resign_num");
            this.erE = jSONObject.optInt("miss_sign_num");
            this.erF = jSONObject.optInt("is_sign_in") == 1;
            this.erG = jSONObject.optInt("user_sign_rank");
        }
    }
}
