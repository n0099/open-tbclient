package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes2.dex */
public class d {
    private static volatile c drV;

    public static synchronized c aIl() {
        c cVar;
        synchronized (d.class) {
            if (drV == null) {
                drV = new c();
            }
            cVar = drV;
        }
        return cVar;
    }
}
