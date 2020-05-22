package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public String fsF;
    public String fsG;
    public String fsH;
    public String fsI;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fsF = jSONObject.optString("pk_count");
            this.fsG = jSONObject.optString("win_rate");
            this.fsH = jSONObject.optString("pk_rank");
            this.fsI = jSONObject.optString("last_pk_res");
        }
    }
}
