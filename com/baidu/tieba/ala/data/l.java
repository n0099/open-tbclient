package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l {
    public String gkA;
    public String gkx;
    public String gky;
    public String gkz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gkx = jSONObject.optString("pk_count");
            this.gky = jSONObject.optString("win_rate");
            this.gkz = jSONObject.optString("pk_rank");
            this.gkA = jSONObject.optString("last_pk_res");
        }
    }
}
