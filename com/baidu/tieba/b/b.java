package com.baidu.tieba.b;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.f;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.a.k;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
public final class b extends f {
    private static final String e = String.valueOf(n.a) + "c/u/feed/forum";
    private int c = 0;
    private String d;

    public final String b(String str) {
        a("pn", str);
        a("rn", String.valueOf(20));
        this.a.a().a().a = true;
        a(e);
        p.c();
        int b = i.b(p.d());
        p.c();
        int c = i.c(p.d());
        float f = b / 320.0f;
        int i = bd.a().b() ? 2 : 1;
        this.a.a("scr_w", String.valueOf(b));
        this.a.a("scr_h", String.valueOf(c));
        this.a.a("scr_dip", String.valueOf(f));
        this.a.a("q_type", String.valueOf(i));
        String i2 = this.a.i();
        if (this.a.a().b().b()) {
            this.b = new NewErrorData();
            this.b.parserJson(i2);
            return i2;
        } else if (this.a.c()) {
            this.c = this.a.d();
            this.d = this.a.f();
            return null;
        } else {
            this.c = -1;
            p.c();
            this.d = p.d().getResources().getString(k.neterror);
            return null;
        }
    }

    @Override // com.baidu.tbadk.core.f
    public final int e() {
        if (this.b != null) {
            return this.b.getErrorNumber();
        }
        if (this.c == 0) {
            return this.c;
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.f
    public final String f() {
        if (this.b != null) {
            return this.b.getErrorMsg();
        }
        if (this.d != null) {
            return this.d;
        }
        return "";
    }
}
