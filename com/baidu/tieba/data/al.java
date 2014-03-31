package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class al {
    private long a = -1;
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = "";

    public final String a() {
        return this.e;
    }

    public final void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                try {
                    this.a = jSONObject.optLong("message_id");
                    this.b = jSONObject.optString("link");
                    this.c = jSONObject.optString("content");
                    this.d = jSONObject.optString("to");
                    this.e = jSONObject.optString("stat");
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("MssageData", "parserJson", "error = " + e.getMessage());
                }
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b("MssageData", "parserJson", "error = " + e2.getMessage());
        }
    }

    public final long b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }
}
