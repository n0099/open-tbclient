package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes7.dex */
public class c {
    private static volatile b efO;

    public static synchronized b bbc() {
        b bVar;
        synchronized (c.class) {
            if (efO == null) {
                efO = new b();
            }
            bVar = efO;
        }
        return bVar;
    }
}
