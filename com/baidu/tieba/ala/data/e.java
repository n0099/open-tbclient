package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public String feA;
    public String feL;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.feA = jSONObject.optString("gift_url");
        this.feL = jSONObject.optString("gift_num");
    }
}
