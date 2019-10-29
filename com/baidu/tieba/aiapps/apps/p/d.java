package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dsY;

    public static synchronized c aIu() {
        c cVar;
        synchronized (d.class) {
            if (dsY == null) {
                dsY = new c();
            }
            cVar = dsY;
        }
        return cVar;
    }
}
