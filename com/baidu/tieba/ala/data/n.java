package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n {
    public String gAs;
    public String gAt;
    public String gAu;
    public String gAv;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gAs = jSONObject.optString("pk_count");
            this.gAt = jSONObject.optString("win_rate");
            this.gAu = jSONObject.optString("pk_rank");
            this.gAv = jSONObject.optString("last_pk_res");
        }
    }
}
