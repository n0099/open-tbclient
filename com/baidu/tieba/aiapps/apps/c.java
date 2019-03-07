package com.baidu.tieba.aiapps.apps;

import android.app.Application;
import android.util.Log;
import com.baidu.pyramid.runtime.multiprocess.f;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.ubc.p;
/* loaded from: classes4.dex */
public class c {
    private static boolean cQW = false;

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
            p.To();
        }
    }

    private static void f(Application application) {
        com.facebook.drawee.a.a.c.initialize(application);
        if (ProcessUtils.isMainProcess()) {
            axU();
            e.Bf().l(null);
        }
        a.dy(application).axR();
        if (com.baidu.swan.apps.c.DEBUG) {
            com.baidu.swan.apps.am.a.G(0, 1);
        }
    }

    private static void axU() {
        if (com.baidu.swan.apps.core.pms.a.vq()) {
            if (!com.baidu.swan.pms.c.a.AF() && com.baidu.swan.apps.c.DEBUG) {
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
        cQW = z;
    }

    public static boolean axV() {
        return !cQW || com.baidu.swan.apps.an.a.hasLollipop();
    }
}
