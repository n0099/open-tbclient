package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dpH;

    public static synchronized c aGW() {
        c cVar;
        synchronized (d.class) {
            if (dpH == null) {
                dpH = new c();
            }
            cVar = dpH;
        }
        return cVar;
    }
}
