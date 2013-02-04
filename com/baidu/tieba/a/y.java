package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class y extends c {
    final /* synthetic */ x a;
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = null;

    public y(x xVar) {
        this.a = xVar;
    }

    public String a() {
        return this.c;
    }

    @Override // com.baidu.tieba.a.c
    public void a(JSONObject jSONObject) {
        try {
            this.b = jSONObject.optString("provice");
            this.c = jSONObject.optString("city");
            this.d = jSONObject.optString("district");
            this.e = jSONObject.optString("street");
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }
}
