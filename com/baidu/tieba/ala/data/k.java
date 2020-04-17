package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public String feV;
    public String feW;
    public String feX;
    public String feY;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.feV = jSONObject.optString("pk_count");
            this.feW = jSONObject.optString("win_rate");
            this.feX = jSONObject.optString("pk_rank");
            this.feY = jSONObject.optString("last_pk_res");
        }
    }
}
