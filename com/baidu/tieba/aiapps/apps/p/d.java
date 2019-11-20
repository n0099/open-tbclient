package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dsg;

    public static synchronized c aIs() {
        c cVar;
        synchronized (d.class) {
            if (dsg == null) {
                dsg = new c();
            }
            cVar = dsg;
        }
        return cVar;
    }
}
