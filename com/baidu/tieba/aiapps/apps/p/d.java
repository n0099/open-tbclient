package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes2.dex */
public class d {
    private static volatile c djE;

    public static synchronized c aIk() {
        c cVar;
        synchronized (d.class) {
            if (djE == null) {
                djE = new c();
            }
            cVar = djE;
        }
        return cVar;
    }
}
