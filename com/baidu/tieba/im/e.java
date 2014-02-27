package com.baidu.tieba.im;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.chat.q;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.bp;
import com.baidu.tieba.im.message.bs;
import com.baidu.tieba.im.message.bx;
import com.baidu.tieba.im.message.ca;
import com.baidu.tieba.im.message.cb;
import com.baidu.tieba.im.message.cc;
import com.baidu.tieba.im.message.cd;
import com.baidu.tieba.im.message.cf;
import com.baidu.tieba.im.message.ch;
import com.baidu.tieba.im.message.co;
import com.baidu.tieba.im.message.cp;
import com.baidu.tieba.im.message.cq;
import com.baidu.tieba.im.message.cy;
import com.baidu.tieba.im.message.cz;
import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.messageCenter.m;
import com.baidu.tieba.im.messageCenter.o;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.im.net.p;
import com.baidu.tieba.mention.ah;
import com.baidu.tieba.mention.v;
/* loaded from: classes.dex */
public final class e {
    public static long a;
    private static e b = new e();
    private static String c = null;

    private e() {
    }

    public static void a(Context context) {
        h.a();
        com.baidu.tieba.im.coder.a.a().b();
        com.baidu.tieba.im.coder.e.a().a(1001);
        m.a().d();
        p.a().b();
        LocalViewSize.a().a(context);
        com.baidu.tieba.im.messageCenter.d a2 = com.baidu.tieba.im.messageCenter.d.a();
        a2.c(1001, ch.class);
        a2.c(202003, da.class);
        a2.c(1003, da.class);
        a2.c(103004, ca.class);
        a2.c(103111, da.class);
        a2.c(103102, da.class);
        a2.c(103003, cc.class);
        a2.c(202001, bp.class);
        a2.c(205001, bs.class);
        a2.c(103103, cq.class);
        a2.c(103005, cf.class);
        a2.c(103002, bx.class);
        a2.c(103006, cb.class);
        a2.c(103112, cp.class);
        a2.c(103008, cz.class);
        a2.c(103012, cd.class);
        a2.c(106102, co.class);
        a2.c(103105, cy.class);
        o.a();
        com.baidu.tieba.im.b.a.c().a(context);
        com.baidu.tieba.im.c.j.a().b();
        q.b().a();
        l.a().b();
        TiebaSocketLinkService.a();
        TiebaSocketLinkService.a(false, "TiebaImApplication init");
        a = Thread.currentThread().getId();
        com.baidu.adp.lib.util.e.e("=====uid:" + TiebaApplication.v() + " cuid:" + b());
    }

    public static void a() {
        v.a().b(new ah());
        v.a().e(0);
        v.a().c(0);
        v.a().d(0);
        v.a().g();
        com.baidu.tieba.im.db.c.a().b();
        TiebaSocketLinkService.a(true, "change Account");
    }

    public static synchronized String b() {
        String str;
        synchronized (e.class) {
            if (c == null) {
                String j = TiebaApplication.g().j();
                String packageName = TiebaApplication.g().b().getPackageName();
                c = String.valueOf(j) + "|" + packageName + com.baidu.tieba.data.i.u();
            }
            str = c;
        }
        return str;
    }

    public static String c() {
        AccountData y = TiebaApplication.y();
        if (y == null) {
            return null;
        }
        return y.getPortrait();
    }

    public static AccountData d() {
        return TiebaApplication.y();
    }
}
