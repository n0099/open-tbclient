package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes20.dex */
public class d {
    private static volatile c fRP;

    public static synchronized c bJl() {
        c cVar;
        synchronized (d.class) {
            if (fRP == null) {
                fRP = new c();
            }
            cVar = fRP;
        }
        return cVar;
    }
}
