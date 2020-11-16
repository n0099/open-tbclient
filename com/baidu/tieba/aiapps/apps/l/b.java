package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes19.dex */
public class b {
    private static volatile a fXe;

    public static synchronized a bLa() {
        a aVar;
        synchronized (b.class) {
            if (fXe == null) {
                fXe = new a();
            }
            aVar = fXe;
        }
        return aVar;
    }
}
