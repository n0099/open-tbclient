package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes20.dex */
public class d {
    private static volatile c fRu;

    public static synchronized c bIV() {
        c cVar;
        synchronized (d.class) {
            if (fRu == null) {
                fRu = new c();
            }
            cVar = fRu;
        }
        return cVar;
    }
}
