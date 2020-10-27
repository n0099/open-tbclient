package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n {
    public String guE;
    public String guF;
    public String guG;
    public String guH;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.guE = jSONObject.optString("pk_count");
            this.guF = jSONObject.optString("win_rate");
            this.guG = jSONObject.optString("pk_rank");
            this.guH = jSONObject.optString("last_pk_res");
        }
    }
}
