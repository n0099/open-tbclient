package com.baidu.tieba.im;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.pushNotify.p;
/* loaded from: classes.dex */
public class e {
    public static long a;
    private static e b = new e();
    private boolean c = false;

    private e() {
        f();
        i.a(new f(this), new g(this));
    }

    private void f() {
        this.c = com.baidu.tbadk.f.a().a("has_showed_del_ga_tip", false);
    }

    public static e a() {
        return b;
    }

    public static void a(Context context) {
        h.a();
        com.baidu.tieba.im.messageCenter.b.a();
        LocalViewSize.a().a(context);
        com.baidu.tieba.im.messageCenter.a.a(context);
        com.baidu.tieba.im.c.b.a().a(context);
        p.a().b();
        w.b().a();
        com.baidu.tieba.im.db.i.a().b();
        a = Thread.currentThread().getId();
        BdLog.d("=====uid:" + TbadkApplication.getCurrentAccount() + " cuid:" + TbadkApplication.getUniqueIdentifier());
    }

    public static void a(AccountData accountData, Context context) {
        com.baidu.tbadk.coreExtra.messageCenter.a.a().c(new com.baidu.tbadk.coreExtra.b.c());
        com.baidu.tbadk.coreExtra.messageCenter.a.a().e(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.a().c(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.a().d(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.a().j();
        com.baidu.tieba.im.db.d.a().b();
    }

    public static String b() {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            return null;
        }
        return currentAccountObj.getPortrait();
    }

    public static AccountData c() {
        return TbadkApplication.getCurrentAccountObj();
    }

    public boolean d() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
        com.baidu.tbadk.f.a().b("has_showed_del_ga_tip", z);
    }

    public void a(long j) {
        com.baidu.tbadk.f.a().b("nearbygroup_date", j);
    }

    public long e() {
        return com.baidu.tbadk.f.a().a("nearbygroup_date", 0L);
    }
}
