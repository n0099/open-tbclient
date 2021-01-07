package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes7.dex */
public class e {
    private static volatile d goC;

    public static synchronized d bQW() {
        d dVar;
        synchronized (e.class) {
            if (goC == null) {
                goC = new d();
            }
            dVar = goC;
        }
        return dVar;
    }
}
