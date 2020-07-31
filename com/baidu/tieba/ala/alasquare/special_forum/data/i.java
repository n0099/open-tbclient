package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    public int fza;
    public int fzb;
    public int fzc;
    public int fzd;
    public int fze;
    public boolean fzf;
    public int fzg;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.fza = jSONObject.optInt("sign_time");
            this.fzb = jSONObject.optInt("cont_sign_num");
            this.fzc = jSONObject.optInt("cout_total_sign_num");
            this.fzd = jSONObject.optInt("total_resign_num");
            this.fze = jSONObject.optInt("miss_sign_num");
            this.fzf = jSONObject.optInt("is_sign_in") == 1;
            this.fzg = jSONObject.optInt("user_sign_rank");
        }
    }
}
