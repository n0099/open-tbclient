package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n {
    public String gIY;
    public String gIZ;
    public String gJa;
    public String gJb;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gIY = jSONObject.optString("pk_count");
            this.gIZ = jSONObject.optString("win_rate");
            this.gJa = jSONObject.optString("pk_rank");
            this.gJb = jSONObject.optString("last_pk_res");
        }
    }
}
