package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class i {
    public int gIO;
    public int gIP;
    public int gIQ;
    public int gIR;
    public int gIS;
    public boolean gIT;
    public int gIU;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.gIO = jSONObject.optInt("sign_time");
            this.gIP = jSONObject.optInt("cont_sign_num");
            this.gIQ = jSONObject.optInt("cout_total_sign_num");
            this.gIR = jSONObject.optInt("total_resign_num");
            this.gIS = jSONObject.optInt("miss_sign_num");
            this.gIT = jSONObject.optInt("is_sign_in") == 1;
            this.gIU = jSONObject.optInt("user_sign_rank");
        }
    }
}
