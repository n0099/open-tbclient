package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes14.dex */
public class d {
    private static volatile c fiA;

    public static synchronized c bux() {
        c cVar;
        synchronized (d.class) {
            if (fiA == null) {
                fiA = new c();
            }
            cVar = fiA;
        }
        return cVar;
    }
}
