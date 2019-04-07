package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cVW;

    public static synchronized a azH() {
        a aVar;
        synchronized (b.class) {
            if (cVW == null) {
                cVW = new a();
            }
            aVar = cVW;
        }
        return aVar;
    }
}
