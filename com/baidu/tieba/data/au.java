package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.util.bs;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class au {
    private String d;
    private String a = null;
    private String b = null;
    private String c = null;
    private boolean h = false;
    private long e = 0;
    private UserData f = new UserData();
    private String g = null;
    private boolean i = true;

    public final boolean a() {
        return this.i;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.a;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.c;
    }

    public final String f() {
        return this.g;
    }

    public final long g() {
        return this.e;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("tid");
                this.c = jSONObject.optString("title");
                this.b = jSONObject.optString("pid");
                this.h = jSONObject.optInt("is_floor", 0) != 0;
                this.e = jSONObject.optLong("time", 0L) * 1000;
                this.f.parserJson(jSONObject.optJSONObject("author"));
                this.g = jSONObject.optString(PushConstants.EXTRA_CONTENT);
                this.d = jSONObject.optString("fname");
                this.c = bs.g(this.c);
                String g = bs.g(this.g);
                if (!g.equals(this.g)) {
                    this.g = g;
                    this.i = false;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("PostData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
