package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class n {
    public String gUL;
    public String gUM;
    public String gUN;
    public String gUO;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gUL = jSONObject.optString("pk_count");
            this.gUM = jSONObject.optString("win_rate");
            this.gUN = jSONObject.optString("pk_rank");
            this.gUO = jSONObject.optString("last_pk_res");
        }
    }
}
