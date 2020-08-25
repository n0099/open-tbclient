package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    public int fKs;
    public int fKt;
    public int fKu;
    public int fKv;
    public int fKw;
    public boolean fKx;
    public int fKy;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.fKs = jSONObject.optInt("sign_time");
            this.fKt = jSONObject.optInt("cont_sign_num");
            this.fKu = jSONObject.optInt("cout_total_sign_num");
            this.fKv = jSONObject.optInt("total_resign_num");
            this.fKw = jSONObject.optInt("miss_sign_num");
            this.fKx = jSONObject.optInt("is_sign_in") == 1;
            this.fKy = jSONObject.optInt("user_sign_rank");
        }
    }
}
