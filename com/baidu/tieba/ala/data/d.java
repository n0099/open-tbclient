package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    public String dGq;
    public String dGr;
    public String dGs;
    public String dGt;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dGq = jSONObject.optString("pk_count");
            this.dGr = jSONObject.optString("win_rate");
            this.dGs = jSONObject.optString("pk_rank");
            this.dGt = jSONObject.optString("last_pk_res");
        }
    }
}
