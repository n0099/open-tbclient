package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes20.dex */
public class e {
    private static volatile d fJi;

    public static synchronized d bHj() {
        d dVar;
        synchronized (e.class) {
            if (fJi == null) {
                fJi = new d();
            }
            dVar = fJi;
        }
        return dVar;
    }
}
