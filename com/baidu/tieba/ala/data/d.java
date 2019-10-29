package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    public String dHh;
    public String dHi;
    public String dHj;
    public String dHk;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dHh = jSONObject.optString("pk_count");
            this.dHi = jSONObject.optString("win_rate");
            this.dHj = jSONObject.optString("pk_rank");
            this.dHk = jSONObject.optString("last_pk_res");
        }
    }
}
