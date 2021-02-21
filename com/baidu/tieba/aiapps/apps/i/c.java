package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes7.dex */
public class c {
    private static volatile b gmR;

    public static synchronized b bNO() {
        b bVar;
        synchronized (c.class) {
            if (gmR == null) {
                gmR = new b();
            }
            bVar = gmR;
        }
        return bVar;
    }
}
