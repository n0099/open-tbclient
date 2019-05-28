package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dfN;

    public static synchronized b aFY() {
        b bVar;
        synchronized (c.class) {
            if (dfN == null) {
                dfN = new b();
            }
            bVar = dfN;
        }
        return bVar;
    }
}
