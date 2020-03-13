package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public String eAg;
    public String eAh;
    public String eAi;
    public String eAj;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eAg = jSONObject.optString("pk_count");
            this.eAh = jSONObject.optString("win_rate");
            this.eAi = jSONObject.optString("pk_rank");
            this.eAj = jSONObject.optString("last_pk_res");
        }
    }
}
