package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public String eAC;
    public String eAD;
    public String eAE;
    public String eAF;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eAC = jSONObject.optString("pk_count");
            this.eAD = jSONObject.optString("win_rate");
            this.eAE = jSONObject.optString("pk_rank");
            this.eAF = jSONObject.optString("last_pk_res");
        }
    }
}
