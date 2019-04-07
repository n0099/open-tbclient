package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class d {
    private static volatile c cRe;

    public static synchronized c axX() {
        c cVar;
        synchronized (d.class) {
            if (cRe == null) {
                cRe = new c();
            }
            cVar = cRe;
        }
        return cVar;
    }
}
