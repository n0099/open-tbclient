package com.baidu.tieba.im;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.db.ag;
import com.baidu.tieba.im.messageCenter.PingManager;
import com.baidu.tieba.im.messageCenter.o;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.mention.ae;
import com.baidu.tieba.mention.t;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static long f1785a;
    private static i b = new i();

    private i() {
    }

    public static void a(TiebaApplication tiebaApplication) {
        l.a();
        b.a();
        PingManager.a().d();
        com.baidu.tieba.im.net.f.a().b();
        LocalViewSize.a().a(tiebaApplication);
        com.baidu.tieba.im.messageCenter.b.a(tiebaApplication);
        o.a(tiebaApplication);
        com.baidu.tieba.im.d.a.a().a(tiebaApplication);
        com.baidu.tieba.im.pushNotify.l.a().b();
        com.baidu.tieba.im.chat.a.b().a();
        ag.a().b();
        TiebaSocketLinkService.a();
        TiebaSocketLinkService.a(false, "TiebaImApplication init");
        f1785a = Thread.currentThread().getId();
        com.baidu.adp.lib.h.e.d("=====uid:" + TiebaApplication.B() + " cuid:" + a());
    }

    public static void a(AccountData accountData, Context context) {
        t.a().c(new ae());
        t.a().d(0L);
        t.a().b(0L);
        t.a().c(0L);
        t.a().h();
        com.baidu.tieba.im.db.l.a().b();
        TiebaSocketLinkService.a(true, "change Account");
    }

    public static String a() {
        return TiebaApplication.h().p() + "|" + Math.abs(TiebaApplication.h().getPackageName().hashCode());
    }

    public static String b() {
        AccountData F = TiebaApplication.F();
        if (F == null) {
            return null;
        }
        return F.getPortrait();
    }
}
