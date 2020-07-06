package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes7.dex */
public class d {
    private static volatile c fdP;

    public static synchronized c brr() {
        c cVar;
        synchronized (d.class) {
            if (fdP == null) {
                fdP = new c();
            }
            cVar = fdP;
        }
        return cVar;
    }
}
