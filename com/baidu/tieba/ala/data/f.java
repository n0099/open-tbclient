package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f {
    public String gUn;
    public String gUy;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.gUn = jSONObject.optString("gift_url");
        this.gUy = jSONObject.optString("gift_num");
    }
}
