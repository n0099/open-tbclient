package com.baidu.tieba.a;

import com.baidu.tieba.util.v;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f855a = String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/f/pb/floor";
    private v b = null;

    public String a(String str, String str2, int i, String str3, int i2) {
        if (str == null || str3 == null) {
            return null;
        }
        this.b = new v(f855a);
        this.b.e(true);
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
        return this.b.j();
    }

    public boolean a() {
        if (this.b == null) {
            return false;
        }
        return this.b.c();
    }

    public String b() {
        if (this.b == null) {
            return null;
        }
        return this.b.g();
    }

    public int c() {
        if (this.b == null) {
            return 0;
        }
        return this.b.e();
    }

    public void d() {
        if (this.b != null) {
            this.b.h();
        }
        this.b = null;
    }
}
