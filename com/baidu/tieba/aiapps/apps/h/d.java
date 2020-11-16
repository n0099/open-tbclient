package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes19.dex */
public class d {
    private static volatile c fWR;

    public static synchronized c bKN() {
        c cVar;
        synchronized (d.class) {
            if (fWR == null) {
                fWR = new c();
            }
            cVar = fWR;
        }
        return cVar;
    }
}
