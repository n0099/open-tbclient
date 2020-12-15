package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public String gIB;
    public String gIL;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.gIB = jSONObject.optString("gift_url");
        this.gIL = jSONObject.optString("gift_num");
    }
}
