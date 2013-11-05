package com.baidu.tieba.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ak;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.n {
    private static final String e = com.baidu.tieba.data.h.f1165a + "c/u/feed/forum";
    private int c = 0;
    private String d;

    public String b(String str) {
        a("pn", str);
        a("rn", String.valueOf(20));
        this.f2027a.e(true);
        a(e);
        String j = this.f2027a.j();
        if (this.f2027a.c()) {
            this.b = new ak();
            this.b.a(j);
            return j;
        } else if (this.f2027a.d()) {
            this.c = this.f2027a.e();
            this.d = this.f2027a.g();
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
            return this.b.a();
        }
        if (this.c == 0) {
            return this.c;
        }
        return -1;
    }

    @Override // com.baidu.tieba.n
    public String f() {
        if (this.b != null) {
            return this.b.b();
        }
        if (this.d != null) {
            return this.d;
        }
        return "";
    }
}
