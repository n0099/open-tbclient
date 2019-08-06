package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dhI;

    public static synchronized c aHz() {
        c cVar;
        synchronized (d.class) {
            if (dhI == null) {
                dhI = new c();
            }
            cVar = dhI;
        }
        return cVar;
    }
}
