package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public String fsG;
    public String fsv;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.fsv = jSONObject.optString("gift_url");
        this.fsG = jSONObject.optString("gift_num");
    }
}
