package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static e a = new e();
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.a.a> b;
    private com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.a.a> c;

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

    public void a(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.b != null) {
            this.b.a(str, aVar);
        }
    }

    public boolean c(int i) {
        return this.c.a(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.c != null) {
            if (BdLog.isDebugMode()) {
                BdLog.d("image joined cache:" + aVar.k() + ", size:" + aVar.f());
            }
            this.c.a(str, aVar);
        }
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void a(String str) {
        this.b.b((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.a.a>) str);
    }

    public com.baidu.adp.widget.a.a b(String str) {
        return this.b.a((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.a.a>) str);
    }

    public com.baidu.adp.widget.a.a c(String str) {
        return this.c.a((com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.a.a>) str);
    }

    public void c() {
        this.b.b();
        this.c.b();
    }

    public String toString() {
        return "pic:" + this.c.toString() + "  photo:" + this.b.toString();
    }
}
