package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    public int eVL;
    public int eVM;
    public int eVN;
    public int eVO;
    public int eVP;
    public boolean eVQ;
    public int eVR;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.eVL = jSONObject.optInt("sign_time");
            this.eVM = jSONObject.optInt("cont_sign_num");
            this.eVN = jSONObject.optInt("cout_total_sign_num");
            this.eVO = jSONObject.optInt("total_resign_num");
            this.eVP = jSONObject.optInt("miss_sign_num");
            this.eVQ = jSONObject.optInt("is_sign_in") == 1;
            this.eVR = jSONObject.optInt("user_sign_rank");
        }
    }
}
