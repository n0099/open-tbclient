package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class as {
    private String a = null;
    private int b = 0;
    private int d = 0;
    private int e = 0;
    private int c = 0;

    public final int a() {
        return this.d;
    }

    public final int b() {
        return this.e;
    }

    public final String c() {
        return this.a;
    }

    public final int d() {
        return this.b;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final int e() {
        return this.c;
    }

    public final void b(int i) {
        this.c = i;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("id");
                this.d = jSONObject.optInt("width", 0);
                this.e = jSONObject.optInt("height", 0);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
