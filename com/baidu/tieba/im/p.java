package com.baidu.tieba.im;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tieba.im.chat.x;
/* loaded from: classes.dex */
public final class p {
    public static long a;
    private static p b = new p();
    private boolean c;

    private p() {
        this.c = false;
        com.baidu.tbadk.s.a();
        this.c = com.baidu.tbadk.s.a("has_showed_del_ga_tip", false);
    }

    public static p a() {
        return b;
    }

    public static void a(Context context) {
        q.a();
        com.baidu.tieba.im.messageCenter.a.a();
        com.baidu.tieba.im.d.a.a();
        LocalViewSize.a().a(context);
        com.baidu.tieba.im.c.b.a().a(context);
        com.baidu.tieba.im.pushNotify.o.a().b();
        x.b().a();
        com.baidu.tieba.im.db.i.a().b();
        a = Thread.currentThread().getId();
        com.baidu.adp.lib.util.f.e("=====uid:" + TbadkApplication.E() + " cuid:" + TbadkApplication.y());
    }

    public static void b() {
        com.baidu.tbadk.coreExtra.messageCenter.a.a().b(new com.baidu.tbadk.coreExtra.b.c());
        com.baidu.tbadk.coreExtra.messageCenter.a.a().e(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.a().c(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.a().d(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.a().h();
        com.baidu.tieba.im.db.d.a().b();
        com.baidu.adp.framework.e.c.a();
        com.baidu.adp.framework.e.c.a(true, "change Account");
    }

    public static String c() {
        AccountData N = TbadkApplication.N();
        if (N == null) {
            return null;
        }
        return N.getPortrait();
    }

    public static AccountData d() {
        return TbadkApplication.N();
    }

    public final boolean e() {
        return this.c;
    }

    public final void a(boolean z) {
        this.c = true;
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("has_showed_del_ga_tip", true);
    }

    public static void a(long j) {
        com.baidu.tbadk.s.a();
        com.baidu.tbadk.s.b("nearbygroup_date", j);
    }

    public static long f() {
        com.baidu.tbadk.s.a();
        return com.baidu.tbadk.s.a("nearbygroup_date", 0L);
    }
}
