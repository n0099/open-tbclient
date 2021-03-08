package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes6.dex */
public class e {
    private static volatile d goz;

    public static synchronized d bNS() {
        d dVar;
        synchronized (e.class) {
            if (goz == null) {
                goz = new d();
            }
            dVar = goz;
        }
        return dVar;
    }
}
