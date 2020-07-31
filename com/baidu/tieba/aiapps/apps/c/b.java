package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes14.dex */
public class b {
    private static volatile a fhA;

    public static synchronized a btK() {
        a aVar;
        synchronized (b.class) {
            if (fhA == null) {
                fhA = new a();
            }
            aVar = fhA;
        }
        return aVar;
    }
}
