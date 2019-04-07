package com.baidu.tieba.aiapps.apps;

import android.app.Application;
import android.util.Log;
import com.baidu.pyramid.runtime.multiprocess.f;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.ubc.o;
import com.baidu.tbadk.s.bc;
/* loaded from: classes4.dex */
public class c {
    private static boolean cQV = false;

    public static void a(Application application, boolean z) {
        fM(z);
        if (axS()) {
            e(application);
            f(application);
        }
    }

    private static void e(Application application) {
        f.a(new com.baidu.tieba.aiapps.apps.p.d());
        if (com.baidu.pyramid.runtime.multiprocess.a.tQ()) {
            o.Tm();
        }
    }

    private static void f(Application application) {
        com.facebook.drawee.a.a.c.initialize(application);
        if (ProcessUtils.isMainProcess()) {
            axR();
            if (bc.jK()) {
                e.Bd().l(null);
            }
        }
        a.dx(application).axO();
        if (com.baidu.swan.apps.b.DEBUG) {
            com.baidu.swan.apps.am.a.G(0, 1);
        }
    }

    private static void axR() {
        if (com.baidu.swan.apps.core.pms.a.vp()) {
            if (!com.baidu.swan.pms.c.a.AE()) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.i("SwanAppInitHelper", "在MaxAge时间周期内，不做UpdateCore请求");
                    return;
                }
                return;
            }
            j.c(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.c.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.pms.c.a(new com.baidu.swan.pms.b.d.d(0), new com.baidu.swan.apps.core.pms.f());
                }
            }, "asyncUpdateSwanAppCore by PMS");
        }
    }

    private static void fM(boolean z) {
        cQV = z;
    }

    public static boolean axS() {
        return !cQV || com.baidu.swan.apps.an.a.hasLollipop();
    }
}
