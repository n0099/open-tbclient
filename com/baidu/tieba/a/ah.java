package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah {
    private String a = null;
    private int b = 0;
    private String c = null;
    private String d = null;
    private String e = null;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optString("id");
            this.b = jSONObject.optInt("type", 0);
            this.c = jSONObject.optString("name");
            if (this.c != null && this.c.length() <= 0) {
                this.c = null;
            }
            this.d = jSONObject.optString("name_show");
            this.e = jSONObject.optString("portrait");
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("MetaData", "parserJson", "error = " + e.getMessage());
        }
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
        this.d = str;
    }

    public String c() {
        return this.d;
    }

    public void c(String str) {
        this.e = str;
    }

    public String d() {
        return this.e;
    }

    public void d(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("MetaData", "parserJson", "error = " + e.getMessage());
        }
    }
}
