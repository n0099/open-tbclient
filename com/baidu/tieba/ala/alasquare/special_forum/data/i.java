package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    public int fiG;
    public int fiH;
    public int fiI;
    public int fiJ;
    public int fiK;
    public boolean fiL;
    public int fiM;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.fiG = jSONObject.optInt("sign_time");
            this.fiH = jSONObject.optInt("cont_sign_num");
            this.fiI = jSONObject.optInt("cout_total_sign_num");
            this.fiJ = jSONObject.optInt("total_resign_num");
            this.fiK = jSONObject.optInt("miss_sign_num");
            this.fiL = jSONObject.optInt("is_sign_in") == 1;
            this.fiM = jSONObject.optInt("user_sign_rank");
        }
    }
}
