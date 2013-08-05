package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private String f1019a;
    private String b;

    public String a() {
        return this.f1019a;
    }

    public String b() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        this.f1019a = jSONObject.optString("img");
        this.b = jSONObject.optString("link");
    }
}
