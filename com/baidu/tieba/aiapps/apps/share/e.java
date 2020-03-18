package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes7.dex */
public class e {
    private static volatile d egK;

    public static synchronized d bbo() {
        d dVar;
        synchronized (e.class) {
            if (egK == null) {
                egK = new d();
            }
            dVar = egK;
        }
        return dVar;
    }
}
