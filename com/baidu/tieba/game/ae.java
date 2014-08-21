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
public class ae {
    private static ae a;
    private static Context b;

    private ae() {
    }

    public static synchronized ae a() {
        ae aeVar;
        synchronized (ae.class) {
            if (a == null) {
                a = new ae();
                b = TbadkApplication.m252getInst().getContext();
            }
            aeVar = a;
        }
        return aeVar;
    }

    public boolean a(com.baidu.tbadk.game.b bVar) {
        if (bVar == null) {
            return false;
        }
        return b.a().c(bVar.a());
    }

    public File a(String str) {
        return b.a().d(str);
    }

    public boolean b(com.baidu.tbadk.game.b bVar) {
        if (bVar == null) {
            return false;
        }
        return b.a().b(bVar.a());
    }

    public void c(com.baidu.tbadk.game.b bVar) {
        if (bVar != null) {
            b.a().a(bVar.f(), bVar.a());
        }
    }

    public void d(com.baidu.tbadk.game.b bVar) {
        if (bVar != null) {
            TiebaStatic.eventStat(b, "dl_game", bVar.a());
            b.a().a(bVar.a(), bVar.f(), bVar.b());
        }
    }

    public void e(com.baidu.tbadk.game.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.n()) && !TextUtils.isEmpty(bVar.o())) {
            UtilHelper.startApk(b, bVar.n(), bVar.o());
        }
    }

    public void f(com.baidu.tbadk.game.b bVar) {
        if (bVar != null) {
            String a2 = bVar.a();
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

    public boolean g(com.baidu.tbadk.game.b bVar) {
        if (bVar == null || bVar.n() == null) {
            return false;
        }
        return UtilHelper.isInstallApk(b, bVar.n());
    }

    public boolean h(com.baidu.tbadk.game.b bVar) {
        if (bVar == null) {
            return false;
        }
        return b.a().b(bVar.a(), bVar.b());
    }

    public void i(com.baidu.tbadk.game.b bVar) {
        if (bVar != null) {
            ak.a().a(bVar);
        }
    }

    public com.baidu.tbadk.game.b c(String str) {
        return ak.a().b(str);
    }

    public List<com.baidu.tbadk.game.b> b() {
        List<com.baidu.tbadk.game.b> b2 = ak.a().b();
        if (b2 == null) {
            return null;
        }
        Iterator<com.baidu.tbadk.game.b> it = b2.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.game.b next = it.next();
            if (next.c() == 1) {
                if (g(next)) {
                    next.c(next.k());
                } else if (a(next)) {
                    next.c(next.l());
                } else {
                    it.remove();
                    ak.a().a(next.a());
                }
            } else {
                next.c(next.k());
            }
        }
        Collections.sort(b2, new af(this));
        return b2;
    }

    public int j(com.baidu.tbadk.game.b bVar) {
        if (g(bVar)) {
            return 5;
        }
        if (a(bVar)) {
            return 4;
        }
        if (b(bVar)) {
            return 2;
        }
        if (!h(bVar)) {
            return 1;
        }
        return 3;
    }

    public List<com.baidu.tbadk.game.b> a(List<com.baidu.tbadk.game.b> list) {
        List<com.baidu.tbadk.game.b> b2 = b();
        if (list == null) {
            return b2;
        }
        for (com.baidu.tbadk.game.b bVar : list) {
            if (g(bVar) || a(bVar)) {
                if (!a(b2, bVar)) {
                    i(bVar);
                    b2.add(bVar);
                }
            }
        }
        return b2;
    }

    private boolean a(List<com.baidu.tbadk.game.b> list, com.baidu.tbadk.game.b bVar) {
        if (list == null || bVar == null) {
            return false;
        }
        for (com.baidu.tbadk.game.b bVar2 : list) {
            if (!TextUtils.isEmpty(bVar.a()) && bVar.a().equals(bVar2.a())) {
                return true;
            }
        }
        return false;
    }
}
