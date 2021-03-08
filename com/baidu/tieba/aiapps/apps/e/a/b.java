package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes6.dex */
public class b {
    private static volatile a goc;

    public static synchronized a bNr() {
        a aVar;
        synchronized (b.class) {
            if (goc == null) {
                goc = new a();
            }
            aVar = goc;
        }
        return aVar;
    }
}
