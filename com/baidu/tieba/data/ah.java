package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ah {
    private int a = -1;
    private String b = null;
    private String c = null;

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("type");
                if (this.a == 3) {
                    this.b = jSONObject.optString("big_pic");
                } else if (this.a == 5) {
                    this.b = jSONObject.optString("vpic");
                    this.c = jSONObject.optString("vsrc");
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }
}
