package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l {
    public String fJw;
    public String fJx;
    public String fJy;
    public String fJz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fJw = jSONObject.optString("pk_count");
            this.fJx = jSONObject.optString("win_rate");
            this.fJy = jSONObject.optString("pk_rank");
            this.fJz = jSONObject.optString("last_pk_res");
        }
    }
}
