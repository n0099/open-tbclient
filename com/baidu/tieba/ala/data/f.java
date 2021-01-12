package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f {
    public String gPH;
    public String gPR;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.gPH = jSONObject.optString("gift_url");
        this.gPR = jSONObject.optString("gift_num");
    }
}
