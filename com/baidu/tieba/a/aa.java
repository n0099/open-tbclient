package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa extends d {
    final /* synthetic */ y a;
    private String b = null;
    private String c = null;
    private int d = 0;
    private int e = 0;
    private int f = 0;

    public aa(y yVar) {
        this.a = yVar;
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.e;
    }

    @Override // com.baidu.tieba.a.d
    public void a(JSONObject jSONObject) {
        try {
            this.b = jSONObject.optString("name");
            this.c = jSONObject.optString("id");
            this.d = jSONObject.optInt("type", 0);
            this.e = jSONObject.optInt("level", 0);
            this.f = jSONObject.optInt("is_like", 0);
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }
}
