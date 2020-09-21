package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    public int fNK;
    public int fNL;
    public int fNM;
    public int fNN;
    public int fNO;
    public boolean fNP;
    public int fNQ;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.fNK = jSONObject.optInt("sign_time");
            this.fNL = jSONObject.optInt("cont_sign_num");
            this.fNM = jSONObject.optInt("cout_total_sign_num");
            this.fNN = jSONObject.optInt("total_resign_num");
            this.fNO = jSONObject.optInt("miss_sign_num");
            this.fNP = jSONObject.optInt("is_sign_in") == 1;
            this.fNQ = jSONObject.optInt("user_sign_rank");
        }
    }
}
