package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes7.dex */
public class d {
    private static volatile c goO;

    public static synchronized c bRf() {
        c cVar;
        synchronized (d.class) {
            if (goO == null) {
                goO = new c();
            }
            cVar = goO;
        }
        return cVar;
    }
}
