package com.baidu.tieba.game;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ac {
    private static ac a;
    private static Context b;

    private ac() {
    }

    public static synchronized ac a() {
        ac acVar;
        synchronized (ac.class) {
            if (a == null) {
                a = new ac();
                b = TbadkApplication.m252getInst().getContext();
            }
            acVar = a;
        }
        return acVar;
    }

    public boolean a(ab abVar) {
        if (abVar == null) {
            return false;
        }
        return b.a().c(abVar.a());
    }

    public File a(String str) {
        return b.a().d(str);
    }

    public boolean b(ab abVar) {
        if (abVar == null) {
            return false;
        }
        return b.a().b(abVar.a());
    }

    public void c(ab abVar) {
        if (abVar != null) {
            b.a().a(abVar.f(), abVar.a());
        }
    }

    public void d(ab abVar) {
        if (abVar != null) {
            TiebaStatic.eventStat(b, "dl_game", abVar.a());
            b.a().a(abVar.a(), abVar.f(), abVar.b());
        }
    }

    public void e(ab abVar) {
        if (abVar != null && !TextUtils.isEmpty(abVar.n()) && !TextUtils.isEmpty(abVar.o())) {
            UtilHelper.startApk(b, abVar.n(), abVar.o());
        }
    }

    public void f(ab abVar) {
        if (abVar != null) {
            String a2 = abVar.a();
            if (!TextUtils.isEmpty(a2)) {
                b(a2);
            }
        }
    }

    public void b(String str) {
        File d;
        if (!TextUtils.isEmpty(str) && (d = com.baidu.tbadk.core.util.s.d(String.valueOf(str) + ".apk")) != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(d), "application/vnd.android.package-archive");
            b.startActivity(intent);
        }
    }

    public boolean g(ab abVar) {
        if (abVar == null || abVar.n() == null) {
            return false;
        }
        return UtilHelper.isInstallApk(b, abVar.n());
    }

    public boolean h(ab abVar) {
        if (abVar == null) {
            return false;
        }
        return b.a().b(abVar.a(), abVar.b());
    }

    public void i(ab abVar) {
        if (abVar != null) {
            ag.a().a(abVar);
        }
    }

    public ab c(String str) {
        return ag.a().b(str);
    }

    public List<ab> b() {
        List<ab> b2 = ag.a().b();
        if (b2 == null) {
            return null;
        }
        Iterator<ab> it = b2.iterator();
        while (it.hasNext()) {
            ab next = it.next();
            if (next.c() == 1) {
                if (g(next)) {
                    next.c(next.k());
                } else if (a(next)) {
                    next.c(next.l());
                } else {
                    it.remove();
                    ag.a().a(next.a());
                }
            } else {
                next.c(next.k());
            }
        }
        Collections.sort(b2, new ad(this));
        return b2;
    }

    public int j(ab abVar) {
        if (g(abVar)) {
            return 5;
        }
        if (a(abVar)) {
            return 4;
        }
        if (b(abVar)) {
            return 2;
        }
        if (!h(abVar)) {
            return 1;
        }
        return 3;
    }

    public List<ab> a(List<ab> list) {
        List<ab> b2 = b();
        if (list == null) {
            return b2;
        }
        for (ab abVar : list) {
            if (g(abVar) || a(abVar)) {
                if (!a(b2, abVar)) {
                    i(abVar);
                    b2.add(abVar);
                }
            }
        }
        return b2;
    }

    private boolean a(List<ab> list, ab abVar) {
        if (list == null || abVar == null) {
            return false;
        }
        for (ab abVar2 : list) {
            if (!TextUtils.isEmpty(abVar.a()) && abVar.a().equals(abVar2.a())) {
                return true;
            }
        }
        return false;
    }
}
