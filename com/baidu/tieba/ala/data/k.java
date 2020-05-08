package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public String ffa;
    public String ffb;
    public String ffc;
    public String ffd;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ffa = jSONObject.optString("pk_count");
            this.ffb = jSONObject.optString("win_rate");
            this.ffc = jSONObject.optString("pk_rank");
            this.ffd = jSONObject.optString("last_pk_res");
        }
    }
}
