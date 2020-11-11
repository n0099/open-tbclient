package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public String gAg;
    public String gzW;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.gzW = jSONObject.optString("gift_url");
        this.gAg = jSONObject.optString("gift_num");
    }
}
