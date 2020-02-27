package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public String ezH;
    public String ezw;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.ezw = jSONObject.optString("gift_url");
        this.ezH = jSONObject.optString("gift_num");
    }
}
