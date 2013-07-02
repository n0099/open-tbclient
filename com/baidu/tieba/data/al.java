package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class al extends b {
    private int a = 0;
    private int b = 0;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private an h = new an();

    public String a() {
        return this.f;
    }

    public int b() {
        return this.b;
    }

    public String c() {
        return this.g;
    }

    public String d() {
        return this.c;
    }

    public an e() {
        return this.h;
    }

    @Override // com.baidu.tieba.data.b
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optInt("type");
            this.c = jSONObject.optString("tid", null);
            this.d = jSONObject.optString("fid", null);
            this.e = jSONObject.optString("fname", null);
            this.f = jSONObject.optString("time", null);
            this.g = jSONObject.optString("position", "");
            this.b = jSONObject.optInt("replyer_count", 0);
            this.h.a(jSONObject);
        }
    }
}
