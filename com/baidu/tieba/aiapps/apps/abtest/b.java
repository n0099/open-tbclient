package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class b {
    private static volatile a daV;

    public static synchronized a aEv() {
        a aVar;
        synchronized (b.class) {
            if (daV == null) {
                daV = new a();
            }
            aVar = daV;
        }
        return aVar;
    }
}
