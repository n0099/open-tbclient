package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes20.dex */
public class d {
    private static volatile c fJu;

    public static synchronized c bHs() {
        c cVar;
        synchronized (d.class) {
            if (fJu == null) {
                fJu = new c();
            }
            cVar = fJu;
        }
        return cVar;
    }
}
