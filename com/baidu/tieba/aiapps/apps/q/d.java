package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dge;

    public static synchronized c aGi() {
        c cVar;
        synchronized (d.class) {
            if (dge == null) {
                dge = new c();
            }
            cVar = dge;
        }
        return cVar;
    }
}
