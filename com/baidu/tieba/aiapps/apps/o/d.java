package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes2.dex */
public class d {
    private static volatile c djt;

    public static synchronized c aId() {
        c cVar;
        synchronized (d.class) {
            if (djt == null) {
                djt = new c();
            }
            cVar = djt;
        }
        return cVar;
    }
}
