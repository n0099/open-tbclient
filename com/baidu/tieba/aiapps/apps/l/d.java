package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes14.dex */
public class d {
    private static volatile c fua;

    public static synchronized c bDt() {
        c cVar;
        synchronized (d.class) {
            if (fua == null) {
                fua = new c();
            }
            cVar = fua;
        }
        return cVar;
    }
}
