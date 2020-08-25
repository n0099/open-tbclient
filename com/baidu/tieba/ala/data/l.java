package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l {
    public String fUN;
    public String fUO;
    public String fUP;
    public String fUQ;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fUN = jSONObject.optString("pk_count");
            this.fUO = jSONObject.optString("win_rate");
            this.fUP = jSONObject.optString("pk_rank");
            this.fUQ = jSONObject.optString("last_pk_res");
        }
    }
}
