package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class i {
    public int gGS;
    public int gGT;
    public int gGU;
    public int gGV;
    public int gGW;
    public boolean gGX;
    public int gGY;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.gGS = jSONObject.optInt("sign_time");
            this.gGT = jSONObject.optInt("cont_sign_num");
            this.gGU = jSONObject.optInt("cout_total_sign_num");
            this.gGV = jSONObject.optInt("total_resign_num");
            this.gGW = jSONObject.optInt("miss_sign_num");
            this.gGX = jSONObject.optInt("is_sign_in") == 1;
            this.gGY = jSONObject.optInt("user_sign_rank");
        }
    }
}
