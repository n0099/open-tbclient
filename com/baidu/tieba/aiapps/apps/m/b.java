package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dhs;

    public static synchronized a aHv() {
        a aVar;
        synchronized (b.class) {
            if (dhs == null) {
                dhs = new a();
            }
            aVar = dhs;
        }
        return aVar;
    }
}
