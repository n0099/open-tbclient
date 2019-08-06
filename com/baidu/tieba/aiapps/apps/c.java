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
    private static boolean daT = false;

    public static void a(Application application, boolean z) {
        gn(z);
        if (aEt()) {
            d(application);
            e(application);
        }
    }

    private static void d(Application application) {
        e.a(new com.baidu.tieba.aiapps.apps.q.d());
        if (com.baidu.pyramid.runtime.multiprocess.a.vb()) {
            q.Yj();
            m.XY().initConfig();
        }
    }

    private static void e(Application application) {
        com.facebook.drawee.a.a.c.initialize(application);
        if (ProcessUtils.isMainProcess()) {
            aEs();
            com.baidu.swan.apps.env.d.CP().l(null);
        }
        a.de(application).aEp();
        if (com.baidu.swan.apps.b.DEBUG) {
            com.baidu.swan.apps.am.a.H(0, 1);
        }
    }

    private static void aEs() {
        final boolean z = true;
        final boolean z2 = com.baidu.swan.apps.core.pms.a.co(0) && com.baidu.swan.pms.d.a.fN(0);
        if (!com.baidu.swan.apps.core.pms.a.co(1) || !com.baidu.swan.pms.d.a.fN(1)) {
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

    private static void gn(boolean z) {
        daT = z;
    }

    public static boolean aEt() {
        return !daT || com.baidu.swan.apps.an.a.hasLollipop();
    }
}
