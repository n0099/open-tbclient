package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dcP;

    public static synchronized a aFb() {
        a aVar;
        synchronized (b.class) {
            if (dcP == null) {
                dcP = new a();
            }
            aVar = dcP;
        }
        return aVar;
    }
}
