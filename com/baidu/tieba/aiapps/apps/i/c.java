package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eTv;

    public static synchronized b boK() {
        b bVar;
        synchronized (c.class) {
            if (eTv == null) {
                eTv = new b();
            }
            bVar = eTv;
        }
        return bVar;
    }
}
