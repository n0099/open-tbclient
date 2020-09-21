package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l {
    public String fYf;
    public String fYg;
    public String fYh;
    public String fYi;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fYf = jSONObject.optString("pk_count");
            this.fYg = jSONObject.optString("win_rate");
            this.fYh = jSONObject.optString("pk_rank");
            this.fYi = jSONObject.optString("last_pk_res");
        }
    }
}
