package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa extends c {
    final /* synthetic */ x a;
    private String b = null;
    private String c = null;
    private String d = null;
    private int e = 0;
    private String f = null;
    private String g = null;
    private int h = 0;
    private long i = 0;

    public aa(x xVar) {
        this.a = xVar;
    }

    public int a() {
        return this.e;
    }

    @Override // com.baidu.tieba.a.c
    public void a(JSONObject jSONObject) {
        try {
            this.b = jSONObject.optString("fname");
            this.c = jSONObject.optString("fid");
            this.d = jSONObject.optString("tid");
            this.e = jSONObject.optInt("type", 0);
            this.f = jSONObject.optString("title");
            this.g = jSONObject.optString("pic_url");
            this.h = jSONObject.optInt("reply_num", 0);
            this.i = jSONObject.optLong("time", 0L);
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public int e() {
        return this.h;
    }

    public long f() {
        return this.i;
    }
}
