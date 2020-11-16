package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n {
    public String gAa;
    public String gAb;
    public String gAc;
    public String gzZ;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gzZ = jSONObject.optString("pk_count");
            this.gAa = jSONObject.optString("win_rate");
            this.gAb = jSONObject.optString("pk_rank");
            this.gAc = jSONObject.optString("last_pk_res");
        }
    }
}
