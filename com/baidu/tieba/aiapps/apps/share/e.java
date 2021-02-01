package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes7.dex */
public class e {
    private static volatile d gmC;

    public static synchronized d bNF() {
        d dVar;
        synchronized (e.class) {
            if (gmC == null) {
                gmC = new d();
            }
            dVar = gmC;
        }
        return dVar;
    }
}
