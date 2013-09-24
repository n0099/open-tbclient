package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class bc {

    /* renamed from: a  reason: collision with root package name */
    private av f1019a;
    private com.baidu.tieba.square.g b;
    private boolean c;
    private long d = 0;

    public bc() {
        this.c = true;
        this.c = true;
    }

    public void a(String str) {
        if (str == null || str.length() < 1) {
            this.c = false;
            return;
        }
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.c = false;
            com.baidu.tieba.util.av.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("recommend_info");
            this.f1019a = new av();
            this.f1019a.a(optJSONObject);
            this.b = new com.baidu.tieba.square.g();
            this.b.b(jSONObject);
            this.d = jSONObject.optLong("time");
        } catch (Exception e) {
            this.c = false;
            com.baidu.tieba.util.av.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public com.baidu.tieba.square.g a() {
        return this.b;
    }

    public av b() {
        return this.f1019a;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        boolean z = false;
        if (this.c) {
            if (this.f1019a == null || this.b == null) {
                z = true;
            }
            return z;
        }
        return true;
    }
}
