package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f806a;
    private String b;

    public b(JSONObject jSONObject) {
        this.f806a = null;
        this.b = null;
        if (jSONObject != null) {
            this.f806a = jSONObject.optString("text");
            this.b = jSONObject.optString("link");
        }
    }

    public b(String str, String str2) {
        this.f806a = null;
        this.b = null;
        this.f806a = str;
        this.b = str2;
    }

    public void a(String str) {
        this.f806a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public String a() {
        return this.f806a;
    }

    public String b() {
        return this.b;
    }

    public void c() {
        if (this.f806a != null) {
            this.f806a = this.f806a.replaceAll("\n", "");
        }
        if (this.b != null) {
            this.b = this.b.replaceAll("\n", "");
        }
    }
}
