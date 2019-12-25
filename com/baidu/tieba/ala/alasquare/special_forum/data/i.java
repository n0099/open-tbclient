package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {
    public int emp;
    public int emq;
    public int emr;
    public int ems;
    public int emt;
    public boolean emu;
    public int emv;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.emp = jSONObject.optInt("sign_time");
            this.emq = jSONObject.optInt("cont_sign_num");
            this.emr = jSONObject.optInt("cout_total_sign_num");
            this.ems = jSONObject.optInt("total_resign_num");
            this.emt = jSONObject.optInt("miss_sign_num");
            this.emu = jSONObject.optInt("is_sign_in") == 1;
            this.emv = jSONObject.optInt("user_sign_rank");
        }
    }
}
