package com.baidu.tbadk.imageManager;

import android.text.TextUtils;
/* loaded from: classes.dex */
public final class e {
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

    public final int b() {
        return this.c.c();
    }

    public final void a(int i, int i2) {
        this.b.b(50);
        a(i2);
    }

    public final void a(int i) {
        this.c.b(i);
    }

    public final void a(String str, com.baidu.adp.widget.ImageView.b bVar) {
        a(str, bVar, false);
    }

    public final void a(String str, com.baidu.adp.widget.ImageView.b bVar, boolean z) {
        if (bVar != null && this.b != null) {
            if (z) {
                str = d(str).a;
            }
            this.b.a(str, bVar);
        }
    }

    public final boolean b(int i) {
        return this.c.a(i);
    }

    public final void b(String str, com.baidu.adp.widget.ImageView.b bVar) {
        if (bVar != null && this.c != null) {
            if (com.baidu.adp.lib.util.e.a()) {
                com.baidu.adp.lib.util.e.e("image joined cache:" + bVar.j() + ", size:" + bVar.f());
            }
            this.c.a(str, bVar);
        }
    }

    public final void c(String str, com.baidu.adp.widget.ImageView.b bVar) {
        b(str, bVar);
    }

    public final void a(String str) {
        this.b.b((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.b>) str);
        h d = d(str);
        if (!TextUtils.isEmpty(d.a) && !d.a.equals(str)) {
            this.b.b((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.b>) d.a);
        }
    }

    public final com.baidu.adp.widget.ImageView.b b(String str) {
        h d = d(str);
        com.baidu.adp.widget.ImageView.b a2 = this.b.a((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.b>) d.a);
        if (a2 != null && a2.b < d.b) {
            this.b.b((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.b>) d.a);
            return null;
        }
        return a2;
    }

    public final com.baidu.adp.widget.ImageView.b c(String str) {
        return this.c.a((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.b>) str);
    }

    public final void c() {
        this.b.a();
        this.c.a();
    }

    public final String toString() {
        return "pic:" + this.c.toString() + "  photo:" + this.b.toString();
    }

    public static h d(String str) {
        h hVar = new h();
        if (str != null) {
            int indexOf = str.indexOf("?");
            hVar.b = 0L;
            hVar.a = str;
            if (indexOf != -1 && str.length() > indexOf + 3) {
                hVar.b = com.baidu.adp.lib.f.b.a(str.substring(indexOf + 3), 0L);
                hVar.a = str.substring(0, indexOf);
            }
        }
        return hVar;
    }
}
