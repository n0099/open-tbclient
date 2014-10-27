package com.baidu.tieba.discover.memberprivilege;

import org.json.JSONObject;
/* loaded from: classes.dex */
class b {
    public String abo;
    public String aph;
    public String mTitle;
    public String zL;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aph = jSONObject.optString("img_url");
            this.mTitle = jSONObject.optString("title");
            this.zL = jSONObject.optString("desc");
            this.abo = jSONObject.optString("link");
        }
    }
}
