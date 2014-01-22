package com.baidu.tieba.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.NewErrorData;
import com.baidu.tieba.n;
import com.baidu.tieba.util.bx;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends n {
    private static final String e = com.baidu.tieba.data.h.a + "c/u/feed/forum";
    private int c = 0;
    private String d;

    public String b(String str) {
        a("pn", str);
        a("rn", String.valueOf(20));
        this.a.e(true);
        a(e);
        int b = com.baidu.adp.lib.g.g.b(TiebaApplication.h());
        int c = com.baidu.adp.lib.g.g.c(TiebaApplication.h());
        float f = b / 320.0f;
        int i = bx.a().b() ? 2 : 1;
        this.a.a("scr_w", String.valueOf(b));
        this.a.a("scr_h", String.valueOf(c));
        this.a.a("scr_dip", String.valueOf(f));
        this.a.a("q_type", String.valueOf(i));
        String m = this.a.m();
        if (this.a.d()) {
            this.b = new NewErrorData();
            this.b.parserJson(m);
            return m;
        } else if (this.a.e()) {
            this.c = this.a.f();
            this.d = this.a.j();
            return null;
        } else {
            this.c = -1;
            this.d = TiebaApplication.h().getResources().getString(R.string.neterror);
            return null;
        }
    }

    @Override // com.baidu.tieba.n
    public int e() {
        if (this.b != null) {
            return this.b.getErrorNumber();
        }
        if (this.c == 0) {
            return this.c;
        }
        return -1;
    }

    @Override // com.baidu.tieba.n
    public String f() {
        if (this.b != null) {
            return this.b.getErrorMsg();
        }
        if (this.d != null) {
            return this.d;
        }
        return "";
    }
}
