package com.baidu.tieba.im;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.h;
import com.baidu.tieba.im.chat.w;
/* loaded from: classes.dex */
public class c {
    public static long a;
    private static c b = new c();
    private boolean c = false;

    private c() {
        f();
        com.baidu.tieba.im.memorycache.c.b();
        com.baidu.tieba.im.pushNotify.d.a();
    }

    private void f() {
        this.c = h.a().a("has_showed_del_ga_tip", false);
    }

    public static c a() {
        return b;
    }

    public static void a(Context context) {
        d.a();
        com.baidu.tieba.im.messageCenter.b.a();
        LocalViewSize.a().a(context);
        com.baidu.tieba.im.messageCenter.a.a(context);
        com.baidu.tieba.im.b.b.b().a(context);
        com.baidu.tieba.im.pushNotify.f.a().b();
        w.a();
        a = Thread.currentThread().getId();
    }

    public static void a(AccountData accountData, Context context) {
        com.baidu.tbadk.coreExtra.messageCenter.a.a().c(new com.baidu.tbadk.coreExtra.b.c());
        com.baidu.tbadk.coreExtra.messageCenter.a.a().d(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.a().b(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.a().c(0);
        com.baidu.tbadk.coreExtra.messageCenter.a.a().l();
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
        h.a().b("has_showed_del_ga_tip", z);
    }

    public void a(long j) {
        h.a().b("nearbygroup_date" + TbadkApplication.getCurrentAccount(), j);
    }

    public long e() {
        return h.a().a("nearbygroup_date" + TbadkApplication.getCurrentAccount(), 0L);
    }
}
