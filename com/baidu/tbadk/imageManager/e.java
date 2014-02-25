package com.baidu.tbadk.imageManager;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class e {
    private static e a = new e();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.b> b;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.b> c;

    public static e a() {
        return a;
    }

    private e() {
        this.b = null;
        this.c = null;
        this.b = new f(this, 0);
        this.c = new g(this, 0);
    }

    public int b() {
        return this.c.d();
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

    public void a(String str, com.baidu.adp.widget.ImageView.b bVar) {
        a(str, bVar, false);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.b bVar, boolean z) {
        if (bVar != null && this.b != null) {
            if (z) {
                str = d(str).a;
            }
            this.b.a(str, bVar);
        }
    }

    public boolean c(int i) {
        return this.c.a(i);
    }

    public void b(String str, com.baidu.adp.widget.ImageView.b bVar, boolean z) {
        if (bVar != null && this.c != null) {
            if (com.baidu.adp.lib.util.f.a()) {
                com.baidu.adp.lib.util.f.e("image joined cache:" + bVar.j() + ", size:" + bVar.f());
            }
            this.c.a(str, bVar);
        }
    }

    public void b(String str, com.baidu.adp.widget.ImageView.b bVar) {
        b(str, bVar, false);
    }

    public void a(String str) {
        this.b.b((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.b>) str);
        h d = d(str);
        if (!TextUtils.isEmpty(d.a) && !d.a.equals(str)) {
            this.b.b((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.b>) d.a);
        }
    }

    public com.baidu.adp.widget.ImageView.b b(String str) {
        h d = d(str);
        com.baidu.adp.widget.ImageView.b a2 = this.b.a((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.b>) d.a);
        if (a2 != null && a2.b < d.b) {
            this.b.b((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.b>) d.a);
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.b c(String str) {
        return this.c.a((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.b>) str);
    }

    public void c() {
        this.b.b();
        this.c.b();
    }

    public String toString() {
        return "pic:" + this.c.toString() + "  photo:" + this.b.toString();
    }

    public static h d(String str) {
        h hVar = new h();
        if (str != null) {
            int indexOf = str.indexOf("?");
            hVar.b = 0L;
            hVar.a = str;
            if (indexOf != -1 && str.length() > "?t=".length() + indexOf) {
                hVar.b = com.baidu.adp.lib.f.b.a(str.substring("?t=".length() + indexOf), 0L);
                hVar.a = str.substring(0, indexOf);
            }
        }
        return hVar;
    }
}
