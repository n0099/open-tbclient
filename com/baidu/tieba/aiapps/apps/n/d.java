package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dfP;

    public static synchronized c aFX() {
        c cVar;
        synchronized (d.class) {
            if (dfP == null) {
                dfP = new c();
            }
            cVar = dfP;
        }
        return cVar;
    }
}
