package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    public int erO;
    public int erP;
    public int erQ;
    public int erR;
    public int erS;
    public boolean erT;
    public int erU;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.erO = jSONObject.optInt("sign_time");
            this.erP = jSONObject.optInt("cont_sign_num");
            this.erQ = jSONObject.optInt("cout_total_sign_num");
            this.erR = jSONObject.optInt("total_resign_num");
            this.erS = jSONObject.optInt("miss_sign_num");
            this.erT = jSONObject.optInt("is_sign_in") == 1;
            this.erU = jSONObject.optInt("user_sign_rank");
        }
    }
}
