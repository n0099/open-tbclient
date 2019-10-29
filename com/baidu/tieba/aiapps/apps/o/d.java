package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dsN;

    public static synchronized c aIn() {
        c cVar;
        synchronized (d.class) {
            if (dsN == null) {
                dsN = new c();
            }
            cVar = dsN;
        }
        return cVar;
    }
}
