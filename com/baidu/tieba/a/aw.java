package com.baidu.tieba.a;

import android.webkit.URLUtil;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aw implements Serializable {
    private String c;
    private int e;
    private String f;
    private String h;
    private int a = 0;
    private int d = 0;
    private String b = null;
    private String g = null;

    public aw() {
        a((String) null);
        this.c = null;
    }

    public String a() {
        return this.f;
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optInt("force_update", 0);
            this.b = jSONObject.optString("new_version", null);
            this.g = jSONObject.optString("new_version_url");
            this.e = jSONObject.optInt("new_version_remind", 0);
            this.f = jSONObject.optString("new_version_desc", null);
            if (this.e != 1 || this.g == null || !URLUtil.isHttpUrl(this.g) || this.b == null || h.h().equalsIgnoreCase(this.b)) {
                return;
            }
            this.d = 1;
            this.c = "tieba_" + this.b + ".apk";
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public int b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.g;
    }

    public int e() {
        return this.d;
    }

    public String f() {
        return this.c;
    }
}
