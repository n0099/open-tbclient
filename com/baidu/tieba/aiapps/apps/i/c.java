package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes14.dex */
public class c {
    private static volatile b ftM;

    public static synchronized b bDm() {
        b bVar;
        synchronized (c.class) {
            if (ftM == null) {
                ftM = new b();
            }
            bVar = ftM;
        }
        return bVar;
    }
}
