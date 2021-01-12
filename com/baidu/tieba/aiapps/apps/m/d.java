package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes6.dex */
public class d {
    private static volatile c gkh;

    public static synchronized c bNn() {
        c cVar;
        synchronized (d.class) {
            if (gkh == null) {
                gkh = new c();
            }
            cVar = gkh;
        }
        return cVar;
    }
}
