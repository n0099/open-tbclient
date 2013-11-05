package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private String f971a;
    private String b;
    private int c;
    private int d;
    private boolean e;

    public e(JSONObject jSONObject) {
        this.f971a = null;
        this.b = null;
        this.c = 1;
        this.d = 1;
        this.e = false;
        if (jSONObject != null) {
            this.f971a = jSONObject.optString("src");
            this.b = jSONObject.optString("cdn_src", "");
            if (this.b == null || this.b.length() == 0) {
                this.b = this.f971a;
            }
            try {
                String[] split = jSONObject.optString("bsize").split(",");
                this.c = Integer.valueOf(split[0]).intValue();
                this.d = Integer.valueOf(split[1]).intValue();
            } catch (Exception e) {
                com.baidu.adp.lib.h.d.a(e.getMessage());
            }
            if (this.c <= 0) {
                this.c = 1;
            }
            if (this.d <= 0) {
                this.d = 1;
            }
            if (this.f971a != null && this.f971a.indexOf(".baidu.com") != -1) {
                this.e = true;
            }
        }
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.c;
    }

    public boolean c() {
        return this.e;
    }

    public String d() {
        return this.f971a;
    }

    public String e() {
        return this.b;
    }
}
