package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dhM;

    public static synchronized c aHE() {
        c cVar;
        synchronized (d.class) {
            if (dhM == null) {
                dhM = new c();
            }
            cVar = dhM;
        }
        return cVar;
    }
}
