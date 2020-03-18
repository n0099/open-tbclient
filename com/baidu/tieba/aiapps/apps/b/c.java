package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eeb;

    public static synchronized b aZR() {
        b bVar;
        synchronized (c.class) {
            if (eeb == null) {
                eeb = new b();
            }
            bVar = eeb;
        }
        return bVar;
    }
}
