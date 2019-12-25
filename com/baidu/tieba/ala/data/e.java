package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public String eua;
    public String eul;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.eua = jSONObject.optString("gift_url");
        this.eul = jSONObject.optString("gift_num");
    }
}
