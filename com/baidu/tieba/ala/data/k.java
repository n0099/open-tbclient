package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public String fsQ;
    public String fsR;
    public String fsS;
    public String fsT;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fsQ = jSONObject.optString("pk_count");
            this.fsR = jSONObject.optString("win_rate");
            this.fsS = jSONObject.optString("pk_rank");
            this.fsT = jSONObject.optString("last_pk_res");
        }
    }
}
