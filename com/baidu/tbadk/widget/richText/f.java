package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private String f993a;
    private String b;
    private String c;
    private int d;
    private int e;
    private boolean f;

    public f(JSONObject jSONObject) {
        this.f993a = null;
        this.b = null;
        this.c = null;
        this.d = 1;
        this.e = 1;
        this.f = false;
        if (jSONObject != null) {
            this.f993a = jSONObject.optString("src");
            this.b = jSONObject.optString("cdn_src", "");
            if (this.b == null || this.b.length() == 0) {
                this.b = this.f993a;
            }
            this.c = jSONObject.optString("big_cdn_src", null);
            try {
                String[] split = jSONObject.optString("bsize").split(",");
                this.d = Integer.valueOf(split[0]).intValue();
                this.e = Integer.valueOf(split[1]).intValue();
            } catch (Exception e) {
                com.baidu.adp.lib.h.e.a(e.getMessage());
            }
            if (this.d <= 0) {
                this.d = 1;
            }
            if (this.e <= 0) {
                this.e = 1;
            }
            if (this.b != null && this.b.indexOf(".baidu.com") != -1) {
                this.f = true;
            }
        }
    }

    public String a() {
        return this.c;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.d;
    }

    public boolean d() {
        return this.f;
    }

    public String e() {
        return this.f993a;
    }

    public String f() {
        return this.b;
    }
}
