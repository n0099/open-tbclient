package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class d {
    private static volatile c cWp;

    public static synchronized c azM() {
        c cVar;
        synchronized (d.class) {
            if (cWp == null) {
                cWp = new c();
            }
            cVar = cWp;
        }
        return cVar;
    }
}
