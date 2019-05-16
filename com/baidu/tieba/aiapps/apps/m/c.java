package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dfM;

    public static synchronized b aFV() {
        b bVar;
        synchronized (c.class) {
            if (dfM == null) {
                dfM = new b();
            }
            bVar = dfM;
        }
        return bVar;
    }
}
