package com.baidu.tbadk.imageManager;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class d {
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.e> c;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.e> d;
    private static d b = new d();

    /* renamed from: a  reason: collision with root package name */
    public static String f982a = "?t=";

    public static d a() {
        return b;
    }

    private d() {
        this.c = null;
        this.d = null;
        this.c = new e(this, 0);
        this.d = new f(this, 0);
    }

    public void a(int i, int i2) {
        a(i);
        b(i2);
    }

    public void a(int i) {
        this.c.c(i);
    }

    public void b(int i) {
        this.d.c(i);
    }

    public int b() {
        return this.d.d();
    }

    public void a(String str, com.baidu.adp.widget.ImageView.e eVar) {
        if (eVar != null && this.c != null) {
            this.c.a(str, eVar);
        }
    }

    public void a(String str, com.baidu.adp.widget.ImageView.e eVar, boolean z) {
        if (z) {
            str = d(str).f985a;
        }
        a(str, eVar);
    }

    public boolean c(int i) {
        return this.d.a(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.e eVar, boolean z) {
        if (eVar != null && this.d != null) {
            if (com.baidu.adp.lib.h.e.a()) {
                com.baidu.adp.lib.h.e.d("image joined cache:" + eVar.h() + ", size:" + eVar.d());
            }
            this.d.a(str, eVar);
        }
    }

    public void b(String str, com.baidu.adp.widget.ImageView.e eVar) {
        b(str, eVar, false);
    }

    public void a(String str) {
        this.c.b((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.e>) str);
        g d = d(str);
        if (!TextUtils.isEmpty(d.f985a) && !d.f985a.equals(str)) {
            this.c.b((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.e>) d.f985a);
        }
    }

    public com.baidu.adp.widget.ImageView.e b(String str) {
        g d = d(str);
        com.baidu.adp.widget.ImageView.e a2 = this.c.a((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.e>) d.f985a);
        if (a2 != null && a2.b < d.b) {
            this.c.b((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.e>) d.f985a);
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.e c(String str) {
        return this.d.a((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.e>) str);
    }

    public void c() {
        this.c.b();
        this.d.b();
    }

    public String toString() {
        return "pic:" + this.d.toString() + "  photo:" + this.c.toString();
    }

    public static g d(String str) {
        g gVar = new g();
        if (str != null) {
            int indexOf = str.indexOf("?");
            gVar.b = 0L;
            gVar.f985a = str;
            if (indexOf != -1 && str.length() > f982a.length() + indexOf) {
                gVar.b = com.baidu.adp.lib.f.b.a(str.substring(f982a.length() + indexOf), 0L);
                gVar.f985a = str.substring(0, indexOf);
            }
        }
        return gVar;
    }
}
