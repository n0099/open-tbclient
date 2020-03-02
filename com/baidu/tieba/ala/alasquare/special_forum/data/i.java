package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    public int erB;
    public int erC;
    public int erD;
    public int erE;
    public int erF;
    public boolean erG;
    public int erH;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.erB = jSONObject.optInt("sign_time");
            this.erC = jSONObject.optInt("cont_sign_num");
            this.erD = jSONObject.optInt("cout_total_sign_num");
            this.erE = jSONObject.optInt("total_resign_num");
            this.erF = jSONObject.optInt("miss_sign_num");
            this.erG = jSONObject.optInt("is_sign_in") == 1;
            this.erH = jSONObject.optInt("user_sign_rank");
        }
    }
}
