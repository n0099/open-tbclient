package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dse;

    public static synchronized d aIp() {
        d dVar;
        synchronized (e.class) {
            if (dse == null) {
                dse = new d();
            }
            dVar = dse;
        }
        return dVar;
    }
}
