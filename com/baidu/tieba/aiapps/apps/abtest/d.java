package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class d {
    private static volatile c cRg;

    public static synchronized c ayb() {
        c cVar;
        synchronized (d.class) {
            if (cRg == null) {
                cRg = new c();
            }
            cVar = cRg;
        }
        return cVar;
    }
}
