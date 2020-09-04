package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    public int fKA;
    public boolean fKB;
    public int fKC;
    public int fKw;
    public int fKx;
    public int fKy;
    public int fKz;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.fKw = jSONObject.optInt("sign_time");
            this.fKx = jSONObject.optInt("cont_sign_num");
            this.fKy = jSONObject.optInt("cout_total_sign_num");
            this.fKz = jSONObject.optInt("total_resign_num");
            this.fKA = jSONObject.optInt("miss_sign_num");
            this.fKB = jSONObject.optInt("is_sign_in") == 1;
            this.fKC = jSONObject.optInt("user_sign_rank");
        }
    }
}
