package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cVX;

    public static synchronized a azH() {
        a aVar;
        synchronized (b.class) {
            if (cVX == null) {
                cVX = new a();
            }
            aVar = cVX;
        }
        return aVar;
    }
}
