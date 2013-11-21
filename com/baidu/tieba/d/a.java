package com.baidu.tieba.d;

import com.baidu.tieba.sharedPref.b;
import com.baidu.tieba.util.bf;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f1159a;
    private int b = 1;
    private int c = 1;
    private int d = 0;
    private boolean e = true;
    private int f = 0;

    public static a a() {
        a aVar;
        if (f1159a == null) {
            synchronized (a.class) {
                if (f1159a == null) {
                    f1159a = new a();
                }
                aVar = f1159a;
            }
            return aVar;
        }
        return f1159a;
    }

    private a() {
    }

    public void b() {
        this.d = b.a().a("image_quality", 0);
        this.b = b.a().a("new_display_photo", 1);
        this.c = b.a().a("new_abstract_state", 0);
        this.f = b.a().a("view_image_quality", 0);
        this.e = b.a().a("show_images", true);
    }

    public void a(int i) {
        this.b = i;
        b.a().b("new_display_photo", i);
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        if (this.b == 0) {
            if (bf.a().c()) {
                return true;
            }
        } else if (this.b == 1) {
            return true;
        }
        return false;
    }

    public void b(int i) {
        if (this.d != i) {
            this.d = i;
            b.a().b("image_quality", i);
        }
    }

    public int e() {
        this.d = b.a().a("image_quality", 0);
        return this.d;
    }

    public boolean f() {
        return this.e;
    }

    public void a(boolean z) {
        if (this.e != z) {
            this.e = z;
            b.a().b("show_images", z);
        }
    }

    public void c(int i) {
        if (this.f != i) {
            this.f = i;
            b.a().b("view_image_quality", i);
            bf.a().f();
            bf.a().g();
        }
    }

    public int g() {
        return this.f;
    }

    public void b(boolean z) {
        if (z) {
            a(0);
            b(0);
            a(true);
            c(0);
            return;
        }
        a(1);
        b(1);
        a(true);
        c(1);
    }

    public boolean h() {
        return this.b == 0 || this.d == 0 || this.f == 0;
    }
}
