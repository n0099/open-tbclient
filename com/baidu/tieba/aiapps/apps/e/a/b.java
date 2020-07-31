package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes14.dex */
public class b {
    private static volatile a fhP;

    public static synchronized a btO() {
        a aVar;
        synchronized (b.class) {
            if (fhP == null) {
                fhP = new a();
            }
            aVar = fhP;
        }
        return aVar;
    }
}
