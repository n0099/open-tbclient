package com.baidu.tbadk.imageManager;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class d {
    private static d a = new d();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.d> b;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.d> c;

    public static d a() {
        return a;
    }

    private d() {
        this.b = null;
        this.c = null;
        this.b = new e(this, 0);
        this.c = new f(this, 0);
    }

    public void a(int i, int i2) {
        a(i);
        b(i2);
    }

    public void a(int i) {
        this.b.c(i);
    }

    public void b(int i) {
        this.c.c(i);
    }

    public int b() {
        return this.c.d();
    }

    public void a(String str, com.baidu.adp.widget.ImageView.d dVar) {
        if (dVar != null && this.b != null) {
            this.b.a(str, dVar);
        }
    }

    public void a(String str, com.baidu.adp.widget.ImageView.d dVar, boolean z) {
        if (z) {
            str = d(str).a;
        }
        a(str, dVar);
    }

    public boolean c(int i) {
        return this.c.a(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.d dVar, boolean z) {
        if (dVar != null && this.c != null) {
            if (com.baidu.adp.lib.h.e.a()) {
                com.baidu.adp.lib.h.e.d("image joined cache:" + dVar.j() + ", size:" + dVar.f());
            }
            this.c.a(str, dVar);
        }
    }

    public void b(String str, com.baidu.adp.widget.ImageView.d dVar) {
        b(str, dVar, false);
    }

    public void a(String str) {
        this.b.b((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.d>) str);
        g d = d(str);
        if (!TextUtils.isEmpty(d.a) && !d.a.equals(str)) {
            this.b.b((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.d>) d.a);
        }
    }

    public com.baidu.adp.widget.ImageView.d b(String str) {
        g d = d(str);
        com.baidu.adp.widget.ImageView.d a2 = this.b.a((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.d>) d.a);
        if (a2 != null && a2.b < d.b) {
            this.b.b((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.d>) d.a);
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.d c(String str) {
        return this.c.a((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.d>) str);
    }

    public void c() {
        this.b.b();
        this.c.b();
    }

    public String toString() {
        return "pic:" + this.c.toString() + "  photo:" + this.b.toString();
    }

    public static g d(String str) {
        g gVar = new g();
        if (str != null) {
            int indexOf = str.indexOf("?");
            gVar.b = 0L;
            gVar.a = str;
            if (indexOf != -1 && str.length() > "?t=".length() + indexOf) {
                gVar.b = com.baidu.adp.lib.f.b.a(str.substring("?t=".length() + indexOf), 0L);
                gVar.a = str.substring(0, indexOf);
            }
        }
        return gVar;
    }
}
