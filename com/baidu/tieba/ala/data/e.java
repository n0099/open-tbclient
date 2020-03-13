package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public String ezK;
    public String ezV;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.ezK = jSONObject.optString("gift_url");
        this.ezV = jSONObject.optString("gift_num");
    }
}
