package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes7.dex */
public class c {
    private static volatile b efN;

    public static synchronized b bba() {
        b bVar;
        synchronized (c.class) {
            if (efN == null) {
                efN = new b();
            }
            bVar = efN;
        }
        return bVar;
    }
}
