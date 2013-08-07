package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    private String f968a;
    private String b;
    private String c;
    private String d;
    private int e;
    private int f;
    private String g;
    private String h;
    private long i;
    private String j;
    private String k;
    private String l;
    private int m;
    private int n;
    private int o;
    private String p;
    private String q;
    private String r;
    private String s;
    private ArrayList t;

    public af() {
        e((String) null);
        f(null);
        h(null);
        g(null);
        a(0);
        b(0);
        i(null);
        j(null);
        a(0L);
        d(0);
        c(0);
        e(0);
        m(null);
        k(null);
        l(null);
        a((String) null);
        b((String) null);
        c((String) null);
        d((String) null);
        this.t = new ArrayList();
    }

    public ArrayList a() {
        return this.t;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                e(jSONObject.optString("forum_id"));
                f(jSONObject.optString("forum_name"));
                g(jSONObject.optString("threadid"));
                h(jSONObject.optString("title"));
                a(jSONObject.optInt("post_num", 0));
                b(jSONObject.optInt("freq_num", 0));
                i(jSONObject.optString("last_user_id"));
                j(jSONObject.optString("last_user_name"));
                a(jSONObject.optLong("last_modified_time", 0L));
                d(jSONObject.optInt("is_top", 0));
                c(jSONObject.optInt("is_good", 0));
                e(jSONObject.optInt("is_up", 0));
                k(jSONObject.optString(PushConstants.EXTRA_USER_ID));
                l(jSONObject.optString("user_name"));
                a(jSONObject.optString("tag_name", null));
                c(jSONObject.optString("tag_id", null));
                b(jSONObject.optString("tag_color", null));
                d(jSONObject.optString("tag_type", null));
                m(jSONObject.optString("abstract", null));
                JSONArray optJSONArray = jSONObject.optJSONArray("media");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ad adVar = new ad();
                        adVar.a(optJSONArray.getJSONObject(i));
                        this.t.add(adVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b("InterestThreadData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void a(String str) {
        this.p = str;
    }

    public String b() {
        return this.p;
    }

    public void b(String str) {
        this.q = str;
    }

    public String c() {
        return this.q;
    }

    public void c(String str) {
        this.r = str;
    }

    public void d(String str) {
        this.s = str;
    }

    public void e(String str) {
        this.f968a = str;
    }

    public void f(String str) {
        this.b = str;
    }

    public String d() {
        return this.b;
    }

    public void g(String str) {
        this.c = str;
    }

    public String e() {
        return this.c;
    }

    public void h(String str) {
        this.d = str;
    }

    public String f() {
        return this.d;
    }

    public void a(int i) {
        this.e = i;
    }

    public int g() {
        return this.e;
    }

    public void b(int i) {
        this.f = i;
    }

    public void i(String str) {
        this.g = str;
    }

    public void j(String str) {
        this.h = str;
    }

    public void a(long j) {
        this.i = j;
    }

    public long h() {
        return this.i;
    }

    public void k(String str) {
        this.j = str;
    }

    public void l(String str) {
        this.k = str;
    }

    public String i() {
        return this.k;
    }

    public void m(String str) {
        this.l = str;
    }

    public String j() {
        return this.l;
    }

    public void c(int i) {
        this.m = i;
    }

    public void d(int i) {
        this.n = i;
    }

    public void e(int i) {
        this.o = i;
    }
}
