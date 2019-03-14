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
    private static boolean cQT = false;

    public static void a(Application application, boolean z) {
        fM(z);
        if (axV()) {
            e(application);
            f(application);
        }
    }

    private static void e(Application application) {
        f.a(new com.baidu.tieba.aiapps.apps.p.d());
        if (com.baidu.pyramid.runtime.multiprocess.a.tR()) {
            o.To();
        }
    }

    private static void f(Application application) {
        com.facebook.drawee.a.a.c.initialize(application);
        if (ProcessUtils.isMainProcess()) {
            axU();
            if (bc.jK()) {
                e.Bf().l(null);
            }
        }
        a.dx(application).axR();
        if (com.baidu.swan.apps.b.DEBUG) {
            com.baidu.swan.apps.am.a.G(0, 1);
        }
    }

    private static void axU() {
        if (com.baidu.swan.apps.core.pms.a.vq()) {
            if (!com.baidu.swan.pms.c.a.AF() && com.baidu.swan.apps.b.DEBUG) {
                Log.i("SwanAppInitHelper", "在MaxAge时间周期内，不做UpdateCore请求");
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
        cQT = z;
    }

    public static boolean axV() {
        return !cQT || com.baidu.swan.apps.an.a.hasLollipop();
    }
}
