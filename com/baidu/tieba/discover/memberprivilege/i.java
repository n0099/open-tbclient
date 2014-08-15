package com.baidu.tieba.discover.memberprivilege;

import org.json.JSONObject;
/* loaded from: classes.dex */
class i {
    public String a;
    public String b;
    public String c;
    public String d;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optString("img_url");
            this.b = jSONObject.optString("title");
            this.c = jSONObject.optString("desc");
            this.d = jSONObject.optString("link");
        }
    }
}
