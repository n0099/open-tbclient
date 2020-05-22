package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eTk;

    public static synchronized b boI() {
        b bVar;
        synchronized (c.class) {
            if (eTk == null) {
                eTk = new b();
            }
            bVar = eTk;
        }
        return bVar;
    }
}
