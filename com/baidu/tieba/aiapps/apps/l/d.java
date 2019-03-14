package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class d {
    private static volatile c cWm;

    public static synchronized c azP() {
        c cVar;
        synchronized (d.class) {
            if (cWm == null) {
                cWm = new c();
            }
            cVar = cWm;
        }
        return cVar;
    }
}
