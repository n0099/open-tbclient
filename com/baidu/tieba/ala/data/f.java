package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f {
    public String fUH;
    public String fUw;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.fUw = jSONObject.optString("gift_url");
        this.fUH = jSONObject.optString("gift_num");
    }
}
