package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    public int eVG;
    public int eVH;
    public int eVI;
    public int eVJ;
    public int eVK;
    public boolean eVL;
    public int eVM;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.eVG = jSONObject.optInt("sign_time");
            this.eVH = jSONObject.optInt("cont_sign_num");
            this.eVI = jSONObject.optInt("cout_total_sign_num");
            this.eVJ = jSONObject.optInt("total_resign_num");
            this.eVK = jSONObject.optInt("miss_sign_num");
            this.eVL = jSONObject.optInt("is_sign_in") == 1;
            this.eVM = jSONObject.optInt("user_sign_rank");
        }
    }
}
