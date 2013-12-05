package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f989a;
    private String b;

    public b(JSONObject jSONObject) {
        this.f989a = null;
        this.b = null;
        if (jSONObject != null) {
            this.f989a = jSONObject.optString("text");
            this.b = jSONObject.optString("link");
        }
    }

    public b(String str, String str2) {
        this.f989a = null;
        this.b = null;
        this.f989a = str;
        this.b = str2;
    }

    public void a(String str) {
        this.f989a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public String a() {
        return this.f989a;
    }

    public String b() {
        return this.b;
    }

    public void c() {
        if (this.f989a != null) {
            this.f989a = this.f989a.replaceAll("\n", "");
        }
        if (this.b != null) {
            this.b = this.b.replaceAll("\n", "");
        }
    }
}
