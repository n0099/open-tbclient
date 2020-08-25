package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes14.dex */
public class d {
    private static volatile c ftC;

    public static synchronized c bDd() {
        c cVar;
        synchronized (d.class) {
            if (ftC == null) {
                ftC = new c();
            }
            cVar = ftC;
        }
        return cVar;
    }
}
