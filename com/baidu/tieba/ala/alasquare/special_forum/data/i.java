package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    public int gpT;
    public int gpU;
    public int gpV;
    public int gpW;
    public int gpX;
    public boolean gpY;
    public int gpZ;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.gpT = jSONObject.optInt("sign_time");
            this.gpU = jSONObject.optInt("cont_sign_num");
            this.gpV = jSONObject.optInt("cout_total_sign_num");
            this.gpW = jSONObject.optInt("total_resign_num");
            this.gpX = jSONObject.optInt("miss_sign_num");
            this.gpY = jSONObject.optInt("is_sign_in") == 1;
            this.gpZ = jSONObject.optInt("user_sign_rank");
        }
    }
}
