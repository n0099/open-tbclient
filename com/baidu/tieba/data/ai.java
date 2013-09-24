package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private int f999a = -1;
    private String b = null;
    private String c = null;

    public int a() {
        return this.f999a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public void a(int i) {
        this.f999a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f999a = jSONObject.optInt("type");
                if (this.f999a == 3) {
                    this.b = jSONObject.optString("big_pic");
                } else if (this.f999a == 5) {
                    this.b = jSONObject.optString("vpic");
                    this.c = jSONObject.optString("vsrc");
                }
            } catch (Exception e) {
                com.baidu.tieba.util.av.b(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }
}
