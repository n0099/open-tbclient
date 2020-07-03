package com.baidu.tieba.ala.alasquare.special_forum.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    public int ftT;
    public int ftU;
    public int ftV;
    public int ftW;
    public int ftX;
    public boolean ftY;
    public int ftZ;
    public long userId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("user_id");
            this.ftT = jSONObject.optInt("sign_time");
            this.ftU = jSONObject.optInt("cont_sign_num");
            this.ftV = jSONObject.optInt("cout_total_sign_num");
            this.ftW = jSONObject.optInt("total_resign_num");
            this.ftX = jSONObject.optInt("miss_sign_num");
            this.ftY = jSONObject.optInt("is_sign_in") == 1;
            this.ftZ = jSONObject.optInt("user_sign_rank");
        }
    }
}
