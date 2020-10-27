package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    public int gkg;
    public int gkh;
    public int gki;
    public int gkj;
    public int gkk;
    public boolean gkl;
    public int gkm;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.gkg = jSONObject.optInt("sign_time");
            this.gkh = jSONObject.optInt("cont_sign_num");
            this.gki = jSONObject.optInt("cout_total_sign_num");
            this.gkj = jSONObject.optInt("total_resign_num");
            this.gkk = jSONObject.optInt("miss_sign_num");
            this.gkl = jSONObject.optInt("is_sign_in") == 1;
            this.gkm = jSONObject.optInt("user_sign_rank");
        }
    }
}
