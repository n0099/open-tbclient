package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f827a;
    private String b;

    public b(JSONObject jSONObject) {
        this.f827a = null;
        this.b = null;
        if (jSONObject != null) {
            this.f827a = jSONObject.optString("text");
            this.b = jSONObject.optString("link");
        }
    }

    public b(String str, String str2) {
        this.f827a = null;
        this.b = null;
        this.f827a = str;
        this.b = str2;
    }

    public void a(String str) {
        this.f827a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public String a() {
        return this.f827a;
    }

    public String b() {
        return this.b;
    }

    public void c() {
        if (this.f827a != null) {
            this.f827a = this.f827a.replaceAll("\n", "");
        }
        if (this.b != null) {
            this.b = this.b.replaceAll("\n", "");
        }
    }
}
