package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public String gzD;
    public String gzN;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.gzD = jSONObject.optString("gift_url");
        this.gzN = jSONObject.optString("gift_num");
    }
}
