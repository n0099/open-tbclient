package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    public int gxJ;
    public int gxK;
    public int gxL;
    public int gxM;
    public int gxN;
    public boolean gxO;
    public int gxP;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.gxJ = jSONObject.optInt("sign_time");
            this.gxK = jSONObject.optInt("cont_sign_num");
            this.gxL = jSONObject.optInt("cout_total_sign_num");
            this.gxM = jSONObject.optInt("total_resign_num");
            this.gxN = jSONObject.optInt("miss_sign_num");
            this.gxO = jSONObject.optInt("is_sign_in") == 1;
            this.gxP = jSONObject.optInt("user_sign_rank");
        }
    }
}
