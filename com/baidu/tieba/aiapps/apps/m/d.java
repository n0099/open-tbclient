package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes7.dex */
public class d {
    private static volatile c eGw;

    public static synchronized c bjl() {
        c cVar;
        synchronized (d.class) {
            if (eGw == null) {
                eGw = new c();
            }
            cVar = eGw;
        }
        return cVar;
    }
}
