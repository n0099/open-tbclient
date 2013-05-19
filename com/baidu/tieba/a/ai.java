package com.baidu.tieba.a;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai implements Serializable {
    private String a = null;
    private int b = 0;
    private String c = null;
    private String d = null;
    private String e = null;

    public void a(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.b = i;
    }

    public int b() {
        return this.b;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.e = str;
    }

    public String e() {
        return this.e;
    }

    public void e(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("MetaData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
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
                com.baidu.tieba.d.ae.b("MetaData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
