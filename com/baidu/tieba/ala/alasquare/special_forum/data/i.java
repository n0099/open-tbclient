package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    public int dCi;
    public int dCj;
    public int dCk;
    public int dCl;
    public int dCm;
    public boolean dCn;
    public int dCo;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.dCi = jSONObject.optInt("sign_time");
            this.dCj = jSONObject.optInt("cont_sign_num");
            this.dCk = jSONObject.optInt("cout_total_sign_num");
            this.dCl = jSONObject.optInt("total_resign_num");
            this.dCm = jSONObject.optInt("miss_sign_num");
            this.dCn = jSONObject.optInt("is_sign_in") == 1;
            this.dCo = jSONObject.optInt("user_sign_rank");
        }
    }
}
