package com.baidu.tieba.data;

import android.graphics.Color;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.util.bs;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    private String d;
    private String a = null;
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
                this.f.parserJson(jSONObject.optJSONObject("author"));
                this.g = jSONObject.optString(PushConstants.EXTRA_CONTENT);
                this.d = jSONObject.optString("fname");
                this.c = bs.a(this.c, (Color) null);
                String a = bs.a(this.g, (Color) null);
                if (!a.equals(this.g)) {
                    this.g = a;
                    this.i = false;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("PostData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
