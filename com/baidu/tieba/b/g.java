package com.baidu.tieba.b;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ba;
/* loaded from: classes.dex */
public final class g {
    private static final String a = String.valueOf(com.baidu.tieba.data.i.a) + "c/f/pb/floor";
    private ba b = null;

    public final String a(String str, String str2, int i, String str3, int i2) {
        if (str == null || str3 == null) {
            return null;
        }
        this.b = new ba(a);
        this.b.e(true);
        this.b.a("kz", str);
        int b = BdUtilHelper.b(TiebaApplication.g().b());
        int c = BdUtilHelper.c(TiebaApplication.g().b());
        float f = TiebaApplication.g().b().getResources().getDisplayMetrics().density;
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
        return this.b.l();
    }

    public final boolean a() {
        if (this.b == null) {
            return false;
        }
        return this.b.c();
    }

    public final String b() {
        if (this.b == null) {
            return null;
        }
        return this.b.i();
    }

    public final int c() {
        if (this.b == null) {
            return 0;
        }
        return this.b.e();
    }

    public final void d() {
        if (this.b != null) {
            this.b.j();
        }
        this.b = null;
    }
}
