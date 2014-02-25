package com.baidu.tieba.im;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.chat.q;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.messageCenter.m;
import com.baidu.tieba.im.messageCenter.o;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.im.net.p;
import com.baidu.tieba.mention.ah;
import com.baidu.tieba.mention.v;
/* loaded from: classes.dex */
public class f {
    public static long a;
    private static f b = new f();
    private static String c = null;

    private f() {
    }

    public static void a(Context context) {
        i.a();
        b.a();
        m.a().d();
        p.a().b();
        LocalViewSize.a().a(context);
        com.baidu.tieba.im.messageCenter.b.a(context);
        o.a(context);
        com.baidu.tieba.im.b.a.c().a(context);
        com.baidu.tieba.im.c.j.a().b();
        q.b().a();
        l.a().b();
        TiebaSocketLinkService.a();
        TiebaSocketLinkService.a(false, "TiebaImApplication init");
        a = Thread.currentThread().getId();
        com.baidu.adp.lib.util.f.e("=====uid:" + TiebaApplication.A() + " cuid:" + a());
    }

    public static void a(AccountData accountData, Context context) {
        v.a().c(new ah());
        v.a().e(0);
        v.a().c(0);
        v.a().d(0);
        v.a().i();
        com.baidu.tieba.im.db.c.a().b();
        TiebaSocketLinkService.a(true, "change Account");
    }

    public static synchronized String a() {
        String str;
        synchronized (f.class) {
            if (c == null) {
                String o = TiebaApplication.g().o();
                String packageName = TiebaApplication.g().b().getPackageName();
                c = String.valueOf(o) + "|" + packageName + com.baidu.tieba.data.i.u();
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

    public static AccountData c() {
        return TiebaApplication.E();
    }
}
