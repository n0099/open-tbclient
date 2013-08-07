package com.baidu.tieba.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class be {

    /* renamed from: a  reason: collision with root package name */
    private String f993a;
    private String b;
    private String c;
    private int d;
    private long e;
    private long f;
    private int g;
    private bf h;

    public void a(String str) {
        this.f993a = str;
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

    public void a(bf bfVar) {
        this.h = bfVar;
    }

    public be d(String str) {
        try {
            return a(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private be a(JSONObject jSONObject) {
        bf a2;
        try {
            be beVar = new be();
            beVar.a(jSONObject.getString("share_id"));
            beVar.b(jSONObject.getString("share_text"));
            beVar.c(jSONObject.getString("result_pic"));
            beVar.a(jSONObject.getInt("error_code"));
            beVar.a(jSONObject.getLong("time"));
            beVar.b(jSONObject.getLong("ctime"));
            beVar.b(jSONObject.getInt("logid"));
            a2 = new bf(this).a(jSONObject.getJSONObject("error"));
            beVar.a(a2);
            return beVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
