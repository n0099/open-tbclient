package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class n {
    public String gSP;
    public String gSQ;
    public String gSR;
    public String gSS;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gSP = jSONObject.optString("pk_count");
            this.gSQ = jSONObject.optString("win_rate");
            this.gSR = jSONObject.optString("pk_rank");
            this.gSS = jSONObject.optString("last_pk_res");
        }
    }
}
