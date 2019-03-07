package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class d {
    private static volatile c cWq;

    public static synchronized c azP() {
        c cVar;
        synchronized (d.class) {
            if (cWq == null) {
                cWq = new c();
            }
            cVar = cWq;
        }
        return cVar;
    }
}
