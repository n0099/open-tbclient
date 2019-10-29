package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dsE;

    public static synchronized a aIl() {
        a aVar;
        synchronized (b.class) {
            if (dsE == null) {
                dsE = new a();
            }
            aVar = dsE;
        }
        return aVar;
    }
}
