package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public String evl;
    public String evw;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.evl = jSONObject.optString("gift_url");
        this.evw = jSONObject.optString("gift_num");
    }
}
