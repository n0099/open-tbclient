package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    public int gpA;
    public int gpB;
    public int gpC;
    public int gpD;
    public int gpE;
    public boolean gpF;
    public int gpG;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.gpA = jSONObject.optInt("sign_time");
            this.gpB = jSONObject.optInt("cont_sign_num");
            this.gpC = jSONObject.optInt("cout_total_sign_num");
            this.gpD = jSONObject.optInt("total_resign_num");
            this.gpE = jSONObject.optInt("miss_sign_num");
            this.gpF = jSONObject.optInt("is_sign_in") == 1;
            this.gpG = jSONObject.optInt("user_sign_rank");
        }
    }
}
