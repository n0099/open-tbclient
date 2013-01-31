package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class z extends d {
    final /* synthetic */ y a;
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = null;

    public z(y yVar) {
        this.a = yVar;
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    @Override // com.baidu.tieba.a.d
    public void a(JSONObject jSONObject) {
        try {
            this.b = jSONObject.optString("provice");
            this.c = jSONObject.optString("city");
            this.d = jSONObject.optString("district");
            this.e = jSONObject.optString("street");
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }
}
