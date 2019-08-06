package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes2.dex */
public class e {
    private static volatile d ddh;

    public static synchronized d aFF() {
        d dVar;
        synchronized (e.class) {
            if (ddh == null) {
                ddh = new d();
            }
            dVar = ddh;
        }
        return dVar;
    }
}
