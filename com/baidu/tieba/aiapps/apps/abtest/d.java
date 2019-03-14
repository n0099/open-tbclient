package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class d {
    private static volatile c cRc;

    public static synchronized c aya() {
        c cVar;
        synchronized (d.class) {
            if (cRc == null) {
                cRc = new c();
            }
            cVar = cRc;
        }
        return cVar;
    }
}
