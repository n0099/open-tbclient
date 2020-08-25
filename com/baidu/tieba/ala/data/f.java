package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f {
    public String fUD;
    public String fUs;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.fUs = jSONObject.optString("gift_url");
        this.fUD = jSONObject.optString("gift_num");
    }
}
