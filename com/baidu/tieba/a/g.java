package com.baidu.tieba.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ax;
/* loaded from: classes.dex */
public class g {
    private static final String a = com.baidu.tieba.data.h.a + "c/f/pb/floor";
    private ax b = null;

    public String a(String str, String str2, int i, String str3, int i2) {
        if (str == null || str3 == null) {
            return null;
        }
        this.b = new ax(a);
        this.b.e(true);
        this.b.a("kz", str);
        int b = com.baidu.adp.lib.g.g.b(TiebaApplication.h());
        int c = com.baidu.adp.lib.g.g.c(TiebaApplication.h());
        float f = TiebaApplication.h().getResources().getDisplayMetrics().density;
        this.b.a("scr_w", String.valueOf(b));
        this.b.a("scr_h", String.valueOf(c));
        this.b.a("scr_dip", String.valueOf(f));
        if (str2 != null) {
            this.b.a("st_type", str2);
        }
        switch (i) {
            case 0:
            case 2:
            case 3:
                this.b.a("pid", str3);
                this.b.a("pn", String.valueOf(i2));
                break;
            case 1:
                this.b.a("spid", str3);
                break;
        }
        return this.b.m();
    }

    public boolean a() {
        if (this.b == null) {
            return false;
        }
        return this.b.d();
    }

    public String b() {
        if (this.b == null) {
            return null;
        }
        return this.b.j();
    }

    public int c() {
        if (this.b == null) {
            return 0;
        }
        return this.b.f();
    }

    public void d() {
        if (this.b != null) {
            this.b.k();
        }
        this.b = null;
    }
}
