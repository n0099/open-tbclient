package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public String ezT;
    public String ezU;
    public String ezV;
    public String ezW;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ezT = jSONObject.optString("pk_count");
            this.ezU = jSONObject.optString("win_rate");
            this.ezV = jSONObject.optString("pk_rank");
            this.ezW = jSONObject.optString("last_pk_res");
        }
    }
}
