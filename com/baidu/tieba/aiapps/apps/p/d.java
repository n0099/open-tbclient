package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dhT;

    public static synchronized c aHG() {
        c cVar;
        synchronized (d.class) {
            if (dhT == null) {
                dhT = new c();
            }
            cVar = dhT;
        }
        return cVar;
    }
}
