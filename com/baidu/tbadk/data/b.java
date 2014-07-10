package com.baidu.tbadk.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int a = 1;
    private int b = 1;
    private int c = 1;
    private int d = 1;
    private int e = 1;

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optInt("location", 1);
            this.b = jSONObject.optInt("like", 1);
            this.c = jSONObject.optInt("group", 1);
            this.d = jSONObject.optInt("post", 1);
            this.e = jSONObject.optInt("friend", 1);
        }
    }
}
