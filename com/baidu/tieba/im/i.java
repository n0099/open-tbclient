package com.baidu.tieba.im;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.chat.q;
import com.baidu.tieba.im.db.ah;
import com.baidu.tieba.im.messageCenter.PingManager;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.mention.ad;
import com.baidu.tieba.mention.s;
/* loaded from: classes.dex */
public class i {
    public static long a;
    private static i b = new i();
    private static String c = null;

    private i() {
    }

    public static void a(TiebaApplication tiebaApplication) {
        l.a();
        b.a();
        PingManager.a().d();
        com.baidu.tieba.im.net.f.a().b();
        LocalViewSize.a().a(tiebaApplication);
        com.baidu.tieba.im.messageCenter.b.a(tiebaApplication);
        com.baidu.tieba.im.messageCenter.o.a(tiebaApplication);
        com.baidu.tieba.im.b.a.c().a(tiebaApplication);
        com.baidu.tieba.im.c.m.a().b();
        q.b().a();
        ah.a().b();
        TiebaSocketLinkService.a();
        TiebaSocketLinkService.a(false, "TiebaImApplication init");
        a = Thread.currentThread().getId();
        com.baidu.adp.lib.g.e.d("=====uid:" + TiebaApplication.A() + " cuid:" + a());
    }

    public static void a(AccountData accountData, Context context) {
        s.a().c(new ad());
        s.a().e(0);
        s.a().c(0);
        s.a().d(0);
        s.a().i();
        com.baidu.tieba.im.db.l.a().b();
        TiebaSocketLinkService.a(true, "change Account");
    }

    public static synchronized String a() {
        String str;
        synchronized (i.class) {
            if (c == null) {
                String o = TiebaApplication.h().o();
                String packageName = TiebaApplication.h().getPackageName();
                c = o + "|" + packageName + com.baidu.tieba.data.h.j();
            }
            str = c;
        }
        return str;
    }

    public static String b() {
        AccountData E = TiebaApplication.E();
        if (E == null) {
            return null;
        }
        return E.getPortrait();
    }
}
