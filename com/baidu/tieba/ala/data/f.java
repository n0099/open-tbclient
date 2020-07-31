package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public String fJb;
    public String fJm;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.fJb = jSONObject.optString("gift_url");
        this.fJm = jSONObject.optString("gift_num");
    }
}
