package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public String gke;
    public String gko;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.gke = jSONObject.optString("gift_url");
        this.gko = jSONObject.optString("gift_num");
    }
}
