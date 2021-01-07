package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes7.dex */
public class c {
    private static volatile b goD;

    public static synchronized b bQY() {
        b bVar;
        synchronized (c.class) {
            if (goD == null) {
                goD = new b();
            }
            bVar = goD;
        }
        return bVar;
    }
}
