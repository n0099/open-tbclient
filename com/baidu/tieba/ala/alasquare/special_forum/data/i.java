package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    public int esk;
    public int esl;
    public int esm;
    public int esn;
    public int eso;
    public boolean esp;
    public int esq;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.esk = jSONObject.optInt("sign_time");
            this.esl = jSONObject.optInt("cont_sign_num");
            this.esm = jSONObject.optInt("cout_total_sign_num");
            this.esn = jSONObject.optInt("total_resign_num");
            this.eso = jSONObject.optInt("miss_sign_num");
            this.esp = jSONObject.optInt("is_sign_in") == 1;
            this.esq = jSONObject.optInt("user_sign_rank");
        }
    }
}
