package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes7.dex */
public class d {
    private static volatile c gmO;

    public static synchronized c bNO() {
        c cVar;
        synchronized (d.class) {
            if (gmO == null) {
                gmO = new c();
            }
            cVar = gmO;
        }
        return cVar;
    }
}
