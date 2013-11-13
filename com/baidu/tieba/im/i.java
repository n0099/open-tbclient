package com.baidu.tieba.im;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.db.aa;
import com.baidu.tieba.im.messageCenter.r;
import com.baidu.tieba.im.net.link.TiebaSocketLinkService;
import com.baidu.tieba.mention.ae;
import com.baidu.tieba.mention.t;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static long f1721a;
    private static i b = new i();

    private i() {
    }

    public static void a(TiebaApplication tiebaApplication) {
        l.a();
        b.a();
        LocalViewSize.a().a(tiebaApplication);
        com.baidu.tieba.im.messageCenter.b.a(tiebaApplication);
        r.a(tiebaApplication);
        com.baidu.tieba.im.c.a.a().a(tiebaApplication);
        com.baidu.tieba.im.pushNotify.n.a().b();
        com.baidu.tieba.im.chat.a.b().a();
        aa.a().b();
        TiebaSocketLinkService.a();
        TiebaSocketLinkService.a(false, "TiebaImApplication init");
        f1721a = Thread.currentThread().getId();
        com.baidu.adp.lib.h.d.d("=====uid:" + TiebaApplication.A() + " cuid:" + a());
    }

    public static void a(AccountData accountData, Context context) {
        t.a().c(new ae());
        t.a().d(0L);
        t.a().b(0L);
        t.a().c(0L);
        t.a().h();
        TiebaSocketLinkService.a(true, "change Account");
    }

    public static String a() {
        return TiebaApplication.g().o() + "|" + Math.abs(TiebaApplication.g().getPackageName().hashCode());
    }

    public static String b() {
        AccountData E = TiebaApplication.E();
        if (E == null) {
            return null;
        }
        return E.getPortrait();
    }
}
