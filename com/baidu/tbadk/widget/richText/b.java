package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f602a;
    private String b;

    public b(JSONObject jSONObject) {
        this.f602a = null;
        this.b = null;
        if (jSONObject != null) {
            this.f602a = jSONObject.optString("text");
            this.b = jSONObject.optString("link");
        }
    }

    public b(String str, String str2) {
        this.f602a = null;
        this.b = null;
        this.f602a = str;
        this.b = str2;
    }

    public void a(String str) {
        this.f602a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public String a() {
        return this.f602a;
    }

    public String b() {
        return this.b;
    }

    public void c() {
        if (this.f602a != null) {
            this.f602a = this.f602a.replaceAll("\n", "");
        }
        if (this.b != null) {
            this.b = this.b.replaceAll("\n", "");
        }
    }
}
