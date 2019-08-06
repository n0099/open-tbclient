package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddi;

    public static synchronized a aFG() {
        a aVar;
        synchronized (b.class) {
            if (ddi == null) {
                ddi = new a();
            }
            aVar = ddi;
        }
        return aVar;
    }
}
