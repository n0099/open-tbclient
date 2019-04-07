package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cRa;

    public static synchronized a axV() {
        a aVar;
        synchronized (b.class) {
            if (cRa == null) {
                cRa = new a();
            }
            aVar = cRa;
        }
        return aVar;
    }
}
