package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public String eAg;
    public String eAr;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.eAg = jSONObject.optString("gift_url");
        this.eAr = jSONObject.optString("gift_num");
    }
}
