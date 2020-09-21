package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public String fXL;
    public String fXW;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.fXL = jSONObject.optString("gift_url");
        this.fXW = jSONObject.optString("gift_num");
    }
}
