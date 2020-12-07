package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n {
    public String gIW;
    public String gIX;
    public String gIY;
    public String gIZ;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gIW = jSONObject.optString("pk_count");
            this.gIX = jSONObject.optString("win_rate");
            this.gIY = jSONObject.optString("pk_rank");
            this.gIZ = jSONObject.optString("last_pk_res");
        }
    }
}
