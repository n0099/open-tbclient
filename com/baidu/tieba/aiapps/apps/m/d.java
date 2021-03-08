package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes6.dex */
public class d {
    private static volatile c goL;

    public static synchronized c bOb() {
        c cVar;
        synchronized (d.class) {
            if (goL == null) {
                goL = new c();
            }
            cVar = goL;
        }
        return cVar;
    }
}
