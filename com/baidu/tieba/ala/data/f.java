package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public String gui;
    public String gus;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.gui = jSONObject.optString("gift_url");
        this.gus = jSONObject.optString("gift_num");
    }
}
