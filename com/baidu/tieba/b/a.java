package com.baidu.tieba.b;

import com.baidu.adp.lib.resourceLoader.BdResourceLoaderNetHelperStatic;
import com.baidu.adp.lib.stats.o;
import com.baidu.kirin.KirinConfig;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a {
    public String a;
    private final int c = 10;
    private final int d = KirinConfig.CONNECT_TIME_OUT;
    private o b = new o("dbg");

    public a(String str) {
        this.a = null;
        this.a = str;
        b.a(str);
    }

    public void a() {
        this.b.a();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        if (this.b != null && BdResourceLoaderNetHelperStatic.a()) {
            e b = b.b(this.a);
            long b2 = this.b.b();
            if (z) {
                b.b.b++;
                if (z2) {
                    b.b.a += b2;
                    b.b.d += j;
                } else {
                    b.b.c++;
                }
            } else {
                b.c.b++;
                if (z2) {
                    b.c.a += b2;
                    b.c.d += j;
                } else {
                    b.c.c++;
                }
            }
            this.b = null;
            b.a(b, 10);
            if (this.a == "frsStat") {
                if (!z2 || b2 > 3000) {
                    o oVar = new o("dbg");
                    oVar.a("act", "frs");
                    oVar.a("result", z2 ? "0" : TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                    oVar.a("isHttp", z ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                    oVar.a("timeCost", String.valueOf(b2));
                    oVar.a("errCode", String.valueOf(i));
                    oVar.a("errMsg", str);
                    oVar.a("down", String.valueOf(j));
                    com.baidu.adp.lib.stats.d.b().a("frs", oVar);
                }
            }
        }
    }

    public void b() {
        if (this.b != null && BdResourceLoaderNetHelperStatic.a()) {
            e b = b.b(this.a);
            long b2 = this.b.b();
            if (b2 > 3000) {
                d dVar = b.d;
                dVar.a = b2 + dVar.a;
                b.d.b++;
                b.a(b, 10);
            }
        }
    }
}
