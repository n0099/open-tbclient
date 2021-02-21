package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class n {
    public String gTd;
    public String gTe;
    public String gTf;
    public String gTg;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gTd = jSONObject.optString("pk_count");
            this.gTe = jSONObject.optString("win_rate");
            this.gTf = jSONObject.optString("pk_rank");
            this.gTg = jSONObject.optString("last_pk_res");
        }
    }
}
