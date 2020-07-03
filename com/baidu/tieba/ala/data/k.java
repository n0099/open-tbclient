package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public String fEb;
    public String fEc;
    public String fEd;
    public String fEe;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fEb = jSONObject.optString("pk_count");
            this.fEc = jSONObject.optString("win_rate");
            this.fEd = jSONObject.optString("pk_rank");
            this.fEe = jSONObject.optString("last_pk_res");
        }
    }
}
