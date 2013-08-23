package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private String f830a;
    private int b;
    private int c;
    private boolean d;

    public e(JSONObject jSONObject) {
        this.f830a = null;
        this.b = 1;
        this.c = 1;
        this.d = false;
        if (jSONObject != null) {
            this.f830a = jSONObject.optString("src");
            try {
                String[] split = jSONObject.optString("bsize").split(",");
                this.b = Integer.valueOf(split[0]).intValue();
                this.c = Integer.valueOf(split[1]).intValue();
            } catch (Exception e) {
                com.baidu.adp.lib.e.d.a(e.getMessage());
            }
            if (this.b <= 0) {
                this.b = 1;
            }
            if (this.c <= 0) {
                this.c = 1;
            }
            if (this.f830a != null && this.f830a.indexOf(".baidu.com") != -1) {
                this.d = true;
            }
        }
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.d;
    }

    public String d() {
        return this.f830a;
    }
}
