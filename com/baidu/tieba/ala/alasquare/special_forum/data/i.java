package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {
    public int enn;
    public int eno;
    public int enp;
    public int enq;
    public int enr;
    public boolean ens;
    public int ent;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.enn = jSONObject.optInt("sign_time");
            this.eno = jSONObject.optInt("cont_sign_num");
            this.enp = jSONObject.optInt("cout_total_sign_num");
            this.enq = jSONObject.optInt("total_resign_num");
            this.enr = jSONObject.optInt("miss_sign_num");
            this.ens = jSONObject.optInt("is_sign_in") == 1;
            this.ent = jSONObject.optInt("user_sign_rank");
        }
    }
}
