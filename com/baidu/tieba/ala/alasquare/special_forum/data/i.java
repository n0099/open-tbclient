package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    public int dBr;
    public int dBs;
    public int dBt;
    public int dBu;
    public int dBv;
    public boolean dBw;
    public int dBx;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.dBr = jSONObject.optInt("sign_time");
            this.dBs = jSONObject.optInt("cont_sign_num");
            this.dBt = jSONObject.optInt("cout_total_sign_num");
            this.dBu = jSONObject.optInt("total_resign_num");
            this.dBv = jSONObject.optInt("miss_sign_num");
            this.dBw = jSONObject.optInt("is_sign_in") == 1;
            this.dBx = jSONObject.optInt("user_sign_rank");
        }
    }
}
