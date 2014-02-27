package com.baidu.tieba.h;

import com.baidu.tieba.sharedPref.b;
import com.baidu.tieba.util.bv;
/* loaded from: classes.dex */
public class a {
    private static a a;
    private int b = 1;
    private int c = 1;
    private int d = 0;
    private boolean e = true;
    private int f = 0;

    public static a a() {
        a aVar;
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
                aVar = a;
            }
            return aVar;
        }
        return a;
    }

    private a() {
    }

    public final void b() {
        this.d = b.a().a("image_quality", 0);
        this.b = b.a().a("new_display_photo", 1);
        this.c = b.a().a("new_abstract_state", 0);
        this.f = b.a().a("view_image_quality", 0);
        this.e = b.a().a("show_images", true);
    }

    public final void a(int i) {
        this.b = i;
        b.a().b("new_display_photo", i);
    }

    public final int c() {
        return this.b;
    }

    public final boolean d() {
        if (this.b == 0) {
            if (bv.a().c()) {
                return true;
            }
        } else if (this.b == 1) {
            return true;
        }
        return false;
    }

    public final void b(int i) {
        if (this.d != i) {
            this.d = i;
            b.a().b("image_quality", i);
        }
    }

    public final int e() {
        this.d = b.a().a("image_quality", 0);
        return this.d;
    }

    public final boolean f() {
        return this.e;
    }

    public final void a(boolean z) {
        if (this.e != z) {
            this.e = z;
            b.a().b("show_images", z);
        }
    }

    public final void c(int i) {
        if (this.f != i) {
            this.f = i;
            b.a().b("view_image_quality", i);
            bv.a().f();
            bv.a().g();
        }
    }

    public final int g() {
        return this.f;
    }

    public final void b(boolean z) {
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

    public final boolean h() {
        return this.b == 0 || this.d == 0 || this.f == 0;
    }
}
