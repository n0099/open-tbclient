package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class i {
    public int gIP;
    public int gIQ;
    public int gIR;
    public int gIS;
    public int gIT;
    public boolean gIU;
    public int gIV;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.gIP = jSONObject.optInt("sign_time");
            this.gIQ = jSONObject.optInt("cont_sign_num");
            this.gIR = jSONObject.optInt("cout_total_sign_num");
            this.gIS = jSONObject.optInt("total_resign_num");
            this.gIT = jSONObject.optInt("miss_sign_num");
            this.gIU = jSONObject.optInt("is_sign_in") == 1;
            this.gIV = jSONObject.optInt("user_sign_rank");
        }
    }
}
