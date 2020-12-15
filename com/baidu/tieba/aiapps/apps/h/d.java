package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes20.dex */
public class d {
    private static volatile c gfe;

    public static synchronized c bOw() {
        c cVar;
        synchronized (d.class) {
            if (gfe == null) {
                gfe = new c();
            }
            cVar = gfe;
        }
        return cVar;
    }
}
