package com.baidu.tieba.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.NewErrorData;
import com.baidu.tieba.n;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bf;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class g extends n {
    private static final String e = com.baidu.tieba.data.h.f1196a + "c/u/feed/forum";
    private int c = 0;
    private String d;

    public String b(String str) {
        a("pn", str);
        a("rn", String.valueOf(20));
        this.f2043a.e(true);
        a(e);
        int a2 = UtilHelper.a(TiebaApplication.g());
        int b = UtilHelper.b(TiebaApplication.g());
        float f = a2 / 320.0f;
        int i = bf.a().b() ? 2 : 1;
        this.f2043a.a("scr_w", String.valueOf(a2));
        this.f2043a.a("scr_h", String.valueOf(b));
        this.f2043a.a("scr_dip", String.valueOf(f));
        this.f2043a.a("q_type", String.valueOf(i));
        String j = this.f2043a.j();
        if (this.f2043a.c()) {
            this.b = new NewErrorData();
            this.b.parserJson(j);
            return j;
        } else if (this.f2043a.d()) {
            this.c = this.f2043a.e();
            this.d = this.f2043a.g();
            return null;
        } else {
            this.c = -1;
            this.d = TiebaApplication.g().getResources().getString(R.string.neterror);
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
