package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    public boolean fiA;
    public int fiB;
    public int fiu;
    public int fiv;
    public int fiw;
    public int fiy;
    public int fiz;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.fiu = jSONObject.optInt("sign_time");
            this.fiv = jSONObject.optInt("cont_sign_num");
            this.fiw = jSONObject.optInt("cout_total_sign_num");
            this.fiy = jSONObject.optInt("total_resign_num");
            this.fiz = jSONObject.optInt("miss_sign_num");
            this.fiA = jSONObject.optInt("is_sign_in") == 1;
            this.fiB = jSONObject.optInt("user_sign_rank");
        }
    }
}
