package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public String gIJ;
    public String gIz;
    public String mGiftName;

    public void parserJson(JSONObject jSONObject) {
        this.mGiftName = jSONObject.optString("gift_name");
        this.gIz = jSONObject.optString("gift_url");
        this.gIJ = jSONObject.optString("gift_num");
    }
}
