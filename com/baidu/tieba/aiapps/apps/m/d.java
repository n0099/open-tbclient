package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes7.dex */
public class d {
    private static volatile c eGr;

    public static synchronized c bjn() {
        c cVar;
        synchronized (d.class) {
            if (eGr == null) {
                eGr = new c();
            }
            cVar = eGr;
        }
        return cVar;
    }
}
