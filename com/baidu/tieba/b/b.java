package com.baidu.tieba.b;

import com.baidu.tieba.a.i;
import com.baidu.tieba.d.t;
/* loaded from: classes.dex */
public class b {
    private static final String a = String.valueOf(i.e) + "c/f/pb/floor";
    private t b = null;

    public String a(String str, String str2, int i, String str3, int i2) {
        if (str == null || str3 == null) {
            return null;
        }
        this.b = new t(a);
        this.b.d(true);
        this.b.a("kz", str);
        if (str2 != null) {
            this.b.a("st_type", str2);
        }
        switch (i) {
            case 0:
            case 2:
                this.b.a("pid", str3);
                this.b.a("pn", String.valueOf(i2));
                break;
            case 1:
                this.b.a("spid", str3);
                break;
        }
        return this.b.i();
    }

    public boolean a() {
        if (this.b == null) {
            return false;
        }
        return this.b.b();
    }

    public String b() {
        if (this.b == null) {
            return null;
        }
        return this.b.f();
    }

    public int c() {
        if (this.b == null) {
            return 0;
        }
        return this.b.d();
    }

    public void d() {
        if (this.b != null) {
            this.b.g();
        }
        this.b = null;
    }
}
