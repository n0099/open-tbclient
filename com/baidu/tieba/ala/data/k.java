package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {
    public String euw;
    public String eux;
    public String euy;
    public String euz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.euw = jSONObject.optString("pk_count");
            this.eux = jSONObject.optString("win_rate");
            this.euy = jSONObject.optString("pk_rank");
            this.euz = jSONObject.optString("last_pk_res");
        }
    }
}
