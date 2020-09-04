package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l {
    public String fUR;
    public String fUS;
    public String fUT;
    public String fUU;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fUR = jSONObject.optString("pk_count");
            this.fUS = jSONObject.optString("win_rate");
            this.fUT = jSONObject.optString("pk_rank");
            this.fUU = jSONObject.optString("last_pk_res");
        }
    }
}
