package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class n {
    public String gQf;
    public String gQg;
    public String gQh;
    public String gQi;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gQf = jSONObject.optString("pk_count");
            this.gQg = jSONObject.optString("win_rate");
            this.gQh = jSONObject.optString("pk_rank");
            this.gQi = jSONObject.optString("last_pk_res");
        }
    }
}
