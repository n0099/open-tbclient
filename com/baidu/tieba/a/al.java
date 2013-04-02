package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class al extends d {
    private int a = 0;
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    private an f = new an();

    public String a() {
        return this.e;
    }

    public String b() {
        return this.b;
    }

    public an c() {
        return this.f;
    }

    @Override // com.baidu.tieba.a.d
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optInt("type");
            this.b = jSONObject.optString("tid", null);
            this.c = jSONObject.optString("fid", null);
            this.d = jSONObject.optString("fname", null);
            this.e = jSONObject.optString("time", null);
            this.f.a(jSONObject);
        }
    }
}
