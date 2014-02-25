package com.baidu.tieba.b;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.NewErrorData;
import com.baidu.tieba.l;
import com.baidu.tieba.util.bv;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends l {
    private static final String e = String.valueOf(com.baidu.tieba.data.i.a) + "c/u/feed/forum";
    private int c = 0;
    private String d;

    public String b(String str) {
        a("pn", str);
        a("rn", String.valueOf(20));
        this.a.e(true);
        a(e);
        int b = BdUtilHelper.b(TiebaApplication.g().b());
        int c = BdUtilHelper.c(TiebaApplication.g().b());
        float f = b / 320.0f;
        int i = bv.a().b() ? 2 : 1;
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
            this.d = TiebaApplication.g().b().getResources().getString(R.string.neterror);
            return null;
        }
    }

    @Override // com.baidu.tieba.l
    public int e() {
        if (this.b != null) {
            return this.b.getErrorNumber();
        }
        if (this.c == 0) {
            return this.c;
        }
        return -1;
    }

    @Override // com.baidu.tieba.l
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
