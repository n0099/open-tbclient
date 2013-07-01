package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {

    /* renamed from: a  reason: collision with root package name */
    private int f755a = -1;
    private String b = null;
    private String c = null;

    public int a() {
        return this.f755a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public void a(int i) {
        this.f755a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f755a = jSONObject.optInt("type");
                if (this.f755a == 3) {
                    this.b = jSONObject.optString("big_pic");
                } else if (this.f755a == 5) {
                    this.b = jSONObject.optString("vpic");
                    this.c = jSONObject.optString("vsrc");
                }
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }
}
