package com.baidu.tbadk.imageManager;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f977a = new d();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.e> b;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.e> c;

    public static d a() {
        return f977a;
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

    public void a(String str, com.baidu.adp.widget.ImageView.e eVar) {
        if (eVar != null && this.b != null) {
            this.b.a(str, eVar);
        }
    }

    public boolean c(int i) {
        return this.c.a(i);
    }

    public void a(String str, com.baidu.adp.widget.ImageView.e eVar, boolean z) {
        if (eVar != null && this.c != null) {
            if (com.baidu.adp.lib.h.d.a()) {
                com.baidu.adp.lib.h.d.d("image joined cache:" + eVar.h() + ", size:" + eVar.d());
            }
            this.c.a(str, eVar);
        }
    }

    public void b(String str, com.baidu.adp.widget.ImageView.e eVar) {
        a(str, eVar, false);
    }

    public void a(String str) {
        this.b.b((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.e>) str);
    }

    public com.baidu.adp.widget.ImageView.e b(String str) {
        return this.b.a((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.e>) str);
    }

    public com.baidu.adp.widget.ImageView.e c(String str) {
        return this.c.a((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.e>) str);
    }

    public void c() {
        this.b.b();
        this.c.b();
    }

    public String toString() {
        return "pic:" + this.c.toString() + "  photo:" + this.b.toString();
    }
}
