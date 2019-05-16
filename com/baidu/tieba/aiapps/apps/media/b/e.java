package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes2.dex */
public class e {
    private static volatile d ddI;

    public static synchronized d aEK() {
        d dVar;
        synchronized (e.class) {
            if (ddI == null) {
                ddI = new d();
            }
            dVar = ddI;
        }
        return dVar;
    }
}
