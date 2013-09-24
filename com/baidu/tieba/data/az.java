package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class az {

    /* renamed from: a  reason: collision with root package name */
    private String f1016a;
    private String b;
    private String c;
    private int d;
    private long e;
    private long f;
    private int g;
    private ba h;

    public void a(String str) {
        this.f1016a = str;
    }

    public String a() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public int b() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.e = j;
    }

    public void b(long j) {
        this.f = j;
    }

    public void b(int i) {
        this.g = i;
    }

    public void a(ba baVar) {
        this.h = baVar;
    }

    public az d(String str) {
        try {
            return a(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private az a(JSONObject jSONObject) {
        ba a2;
        az azVar = new az();
        azVar.a(jSONObject.optString("share_id"));
        azVar.b(jSONObject.optString("share_text"));
        azVar.c(jSONObject.optString("result_pic"));
        azVar.a(jSONObject.optInt("error_code"));
        azVar.a(jSONObject.optLong("time"));
        azVar.b(jSONObject.optLong("ctime"));
        azVar.b(jSONObject.optInt("logid"));
        a2 = new ba(this).a(jSONObject.optJSONObject("error"));
        azVar.a(a2);
        return azVar;
    }
}
