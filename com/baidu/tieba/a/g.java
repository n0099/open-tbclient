package com.baidu.tieba.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.NewErrorData;
import com.baidu.tieba.o;
import com.baidu.tieba.util.bc;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class g extends o {
    private static final String e = com.baidu.tieba.data.h.f1248a + "c/u/feed/forum";
    private int c = 0;
    private String d;

    public String b(String str) {
        a("pn", str);
        a("rn", String.valueOf(20));
        this.f2134a.e(true);
        a(e);
        int b = com.baidu.adp.lib.h.g.b(TiebaApplication.h());
        int c = com.baidu.adp.lib.h.g.c(TiebaApplication.h());
        float f = b / 320.0f;
        int i = bc.a().b() ? 2 : 1;
        this.f2134a.a("scr_w", String.valueOf(b));
        this.f2134a.a("scr_h", String.valueOf(c));
        this.f2134a.a("scr_dip", String.valueOf(f));
        this.f2134a.a("q_type", String.valueOf(i));
        String l = this.f2134a.l();
        if (this.f2134a.c()) {
            this.b = new NewErrorData();
            this.b.parserJson(l);
            return l;
        } else if (this.f2134a.d()) {
            this.c = this.f2134a.e();
            this.d = this.f2134a.i();
            return null;
        } else {
            this.c = -1;
            this.d = TiebaApplication.h().getResources().getString(R.string.neterror);
            return null;
        }
    }

    @Override // com.baidu.tieba.o
    public int e() {
        if (this.b != null) {
            return this.b.getErrorNumber();
        }
        if (this.c == 0) {
            return this.c;
        }
        return -1;
    }

    @Override // com.baidu.tieba.o
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
