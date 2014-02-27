package com.baidu.tieba.b;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.NewErrorData;
import com.baidu.tieba.l;
import com.baidu.tieba.util.bv;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class d extends l {
    private static final String e = String.valueOf(com.baidu.tieba.data.i.a) + "c/u/feed/forum";
    private int c = 0;
    private String d;

    public final String b(String str) {
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
        String l = this.a.l();
        if (this.a.c()) {
            this.b = new NewErrorData();
            this.b.parserJson(l);
            return l;
        } else if (this.a.d()) {
            this.c = this.a.e();
            this.d = this.a.i();
            return null;
        } else {
            this.c = -1;
            this.d = TiebaApplication.g().b().getResources().getString(R.string.neterror);
            return null;
        }
    }

    @Override // com.baidu.tieba.l
    public final int e() {
        if (this.b != null) {
            return this.b.getErrorNumber();
        }
        if (this.c == 0) {
            return this.c;
        }
        return -1;
    }

    @Override // com.baidu.tieba.l
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
