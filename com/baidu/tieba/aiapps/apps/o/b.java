package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eGC;

    public static synchronized a bjv() {
        a aVar;
        synchronized (b.class) {
            if (eGC == null) {
                eGC = new a();
            }
            aVar = eGC;
        }
        return aVar;
    }
}
