package com.baidu.tieba.a;

import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.ai;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.core.e {
    private static final String e = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/feed/forum";
    private int c = 0;
    private String d;

    public String b(String str) {
        a("pn", str);
        a("rn", String.valueOf(20));
        this.a.a().a().a = true;
        a(e);
        int b = j.b(ai.c().d());
        int c = j.c(ai.c().d());
        float f = b / 320.0f;
        int i = bb.a().b() ? 2 : 1;
        this.a.a("scr_w", String.valueOf(b));
        this.a.a("scr_h", String.valueOf(c));
        this.a.a("scr_dip", String.valueOf(f));
        this.a.a("q_type", String.valueOf(i));
        String h = this.a.h();
        if (this.a.a().b().b()) {
            this.b = new NewErrorData();
            this.b.parserJson(h);
            return h;
        } else if (this.a.b()) {
            this.c = this.a.c();
            this.d = this.a.e();
            return null;
        } else {
            this.c = -1;
            this.d = ai.c().d().getResources().getString(x.neterror);
            return null;
        }
    }

    @Override // com.baidu.tbadk.core.e
    public int e() {
        if (this.b != null) {
            return this.b.getErrorNumber();
        }
        if (this.c == 0) {
            return this.c;
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.e
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
