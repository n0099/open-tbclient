package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public String ezS;
    public String ezT;
    public String ezU;
    public String ezV;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ezS = jSONObject.optString("pk_count");
            this.ezT = jSONObject.optString("win_rate");
            this.ezU = jSONObject.optString("pk_rank");
            this.ezV = jSONObject.optString("last_pk_res");
        }
    }
}
