package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes7.dex */
public class c {
    private static volatile b egh;

    public static synchronized b bbj() {
        b bVar;
        synchronized (c.class) {
            if (egh == null) {
                egh = new b();
            }
            bVar = egh;
        }
        return bVar;
    }
}
