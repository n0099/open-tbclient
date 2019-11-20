package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes2.dex */
public class d {
    private static volatile c drN;

    public static synchronized c aIk() {
        c cVar;
        synchronized (d.class) {
            if (drN == null) {
                drN = new c();
            }
            cVar = drN;
        }
        return cVar;
    }
}
