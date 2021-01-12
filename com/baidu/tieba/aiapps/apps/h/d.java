package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes6.dex */
public class d {
    private static volatile c gjM;

    public static synchronized c bMX() {
        c cVar;
        synchronized (d.class) {
            if (gjM == null) {
                gjM = new c();
            }
            cVar = gjM;
        }
        return cVar;
    }
}
