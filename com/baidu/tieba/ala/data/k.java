package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {
    public String evH;
    public String evI;
    public String evJ;
    public String evK;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.evH = jSONObject.optString("pk_count");
            this.evI = jSONObject.optString("win_rate");
            this.evJ = jSONObject.optString("pk_rank");
            this.evK = jSONObject.optString("last_pk_res");
        }
    }
}
