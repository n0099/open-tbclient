package com.baidu.tieba.aiapps.apps;

import android.app.Application;
import com.baidu.pyramid.runtime.multiprocess.e;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.pms.b.d.f;
import com.baidu.swan.ubc.m;
import com.baidu.swan.ubc.q;
/* loaded from: classes4.dex */
public class c {
    private static boolean dlk = false;

    public static void a(Application application, boolean z) {
        gf(z);
        if (aFg()) {
            e(application);
            f(application);
        }
    }

    private static void e(Application application) {
        e.a(new com.baidu.tieba.aiapps.apps.q.d());
        if (com.baidu.pyramid.runtime.multiprocess.a.Aa()) {
            q.adb();
            m.acQ().initConfig();
        }
    }

    private static void f(Application application) {
        com.facebook.drawee.a.a.c.initialize(application);
        if (ProcessUtils.isMainProcess()) {
            aFf();
            com.baidu.swan.apps.env.d.HO().l(null);
        }
        a.cQ(application).aFc();
        if (com.baidu.swan.apps.b.DEBUG) {
            com.baidu.swan.apps.am.a.L(0, 1);
        }
    }

    private static void aFf() {
        final boolean z = true;
        final boolean z2 = com.baidu.swan.apps.core.pms.a.dl(0) && com.baidu.swan.pms.d.a.gI(0);
        if (!com.baidu.swan.apps.core.pms.a.dl(1) || !com.baidu.swan.pms.d.a.gI(1)) {
            z = false;
        }
        if (z2 || z) {
            j.c(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z2) {
                        com.baidu.swan.pms.c.a(new f(0), new com.baidu.swan.apps.core.pms.f());
                    }
                    if (z) {
                        com.baidu.swan.pms.c.a(new f(1), new com.baidu.swan.games.h.b.b());
                    }
                }
            }, "asyncUpdateSwanAppCore by PMS");
        }
    }

    private static void gf(boolean z) {
        dlk = z;
    }

    public static boolean aFg() {
        return !dlk || com.baidu.swan.apps.an.a.hasLollipop();
    }
}
