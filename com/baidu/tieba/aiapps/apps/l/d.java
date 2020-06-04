package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes7.dex */
public class d {
    private static volatile c eTE;

    public static synchronized c boQ() {
        c cVar;
        synchronized (d.class) {
            if (eTE == null) {
                eTE = new c();
            }
            cVar = eTE;
        }
        return cVar;
    }
}
