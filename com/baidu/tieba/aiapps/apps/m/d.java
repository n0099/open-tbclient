package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes7.dex */
public class d {
    private static volatile c egB;

    public static synchronized c bbk() {
        c cVar;
        synchronized (d.class) {
            if (egB == null) {
                egB = new c();
            }
            cVar = egB;
        }
        return cVar;
    }
}
