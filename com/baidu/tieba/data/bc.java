package com.baidu.tieba.data;

import android.graphics.Color;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bc {
    private String d;

    /* renamed from: a  reason: collision with root package name */
    private String f993a = null;
    private String b = null;
    private String c = null;
    private boolean h = false;
    private long e = 0;
    private UserData f = new UserData();
    private String g = null;
    private boolean i = true;

    public boolean a() {
        return this.i;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.f993a;
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
                this.f993a = jSONObject.optString("tid");
                this.c = jSONObject.optString("title");
                this.b = jSONObject.optString("pid");
                this.h = jSONObject.optInt("is_floor", 0) != 0;
                this.e = jSONObject.optLong("time", 0L) * 1000;
                this.f.parserJson(jSONObject.optJSONObject("author"));
                this.g = jSONObject.optString("content");
                this.d = jSONObject.optString("fname");
                this.c = com.baidu.tieba.util.ai.a(this.c, (Color) null);
                String a2 = com.baidu.tieba.util.ai.a(this.g, (Color) null);
                if (!a2.equals(this.g)) {
                    this.g = a2;
                    this.i = false;
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b("PostData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
