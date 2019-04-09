package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class d {
    private static volatile c cRf;

    public static synchronized c axX() {
        c cVar;
        synchronized (d.class) {
            if (cRf == null) {
                cRf = new c();
            }
            cVar = cRf;
        }
        return cVar;
    }
}
