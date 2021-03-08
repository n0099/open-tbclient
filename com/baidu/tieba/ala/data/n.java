package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class n {
    public String gUM;
    public String gUN;
    public String gUO;
    public String gUP;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gUM = jSONObject.optString("pk_count");
            this.gUN = jSONObject.optString("win_rate");
            this.gUO = jSONObject.optString("pk_rank");
            this.gUP = jSONObject.optString("last_pk_res");
        }
    }
}
