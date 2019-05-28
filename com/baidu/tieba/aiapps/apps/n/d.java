package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dfQ;

    public static synchronized c aGa() {
        c cVar;
        synchronized (d.class) {
            if (dfQ == null) {
                dfQ = new c();
            }
            cVar = dfQ;
        }
        return cVar;
    }
}
