package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public String ezI;
    public String ezx;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.ezx = jSONObject.optString("gift_url");
        this.ezI = jSONObject.optString("gift_num");
    }
}
