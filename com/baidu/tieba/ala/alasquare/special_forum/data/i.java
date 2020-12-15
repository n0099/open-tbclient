package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    public int gxL;
    public int gxM;
    public int gxN;
    public int gxO;
    public int gxP;
    public boolean gxQ;
    public int gxR;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.gxL = jSONObject.optInt("sign_time");
            this.gxM = jSONObject.optInt("cont_sign_num");
            this.gxN = jSONObject.optInt("cout_total_sign_num");
            this.gxO = jSONObject.optInt("total_resign_num");
            this.gxP = jSONObject.optInt("miss_sign_num");
            this.gxQ = jSONObject.optInt("is_sign_in") == 1;
            this.gxR = jSONObject.optInt("user_sign_rank");
        }
    }
}
