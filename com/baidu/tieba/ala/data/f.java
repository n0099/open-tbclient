package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f {
    public String gSE;
    public String gSP;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.gSE = jSONObject.optString("gift_url");
        this.gSP = jSONObject.optString("gift_num");
    }
}
