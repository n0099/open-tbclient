package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f {
    public String gSB;
    public String gSq;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.gSq = jSONObject.optString("gift_url");
        this.gSB = jSONObject.optString("gift_num");
    }
}
