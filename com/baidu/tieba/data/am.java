package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class am {

    /* renamed from: a  reason: collision with root package name */
    private int f975a = -1;
    private String b = null;
    private String c = null;

    public int a() {
        return this.f975a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public void a(int i) {
        this.f975a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f975a = jSONObject.optInt("type");
                if (this.f975a == 3) {
                    this.b = jSONObject.optString("big_pic");
                } else if (this.f975a == 5) {
                    this.b = jSONObject.optString("vpic");
                    this.c = jSONObject.optString("vsrc");
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }
}
