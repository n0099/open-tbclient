package com.baidu.tieba.a;

import android.graphics.Color;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq {
    private String d;
    private String a = null;
    private String b = null;
    private String c = null;
    private boolean h = false;
    private long e = 0;
    private ax f = new ax();
    private String g = null;
    private boolean i = true;

    public boolean a() {
        return this.i;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.c;
    }

    public String f() {
        return this.g;
    }

    public long g() {
        return this.e;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("tid");
                this.c = jSONObject.optString("title");
                this.b = jSONObject.optString("pid");
                this.h = jSONObject.optInt("is_floor", 0) != 0;
                this.e = jSONObject.optLong("time", 0L) * 1000;
                this.f.a(jSONObject.optJSONObject("author"));
                this.g = jSONObject.optString("content");
                this.d = jSONObject.optString("fname");
                this.c = com.baidu.tieba.c.ae.a(this.c, (Color) null);
                String a = com.baidu.tieba.c.ae.a(this.g, (Color) null);
                if (!a.equals(this.g)) {
                    this.g = a;
                    this.i = false;
                }
            } catch (Exception e) {
                com.baidu.tieba.c.af.b("PostData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
