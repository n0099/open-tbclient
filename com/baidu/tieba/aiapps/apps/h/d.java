package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes7.dex */
public class d {
    private static volatile c gmH;

    public static synchronized c bNF() {
        c cVar;
        synchronized (d.class) {
            if (gmH == null) {
                gmH = new c();
            }
            cVar = gmH;
        }
        return cVar;
    }
}
