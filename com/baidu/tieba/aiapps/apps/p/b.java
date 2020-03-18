package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes7.dex */
public class b {
    private static volatile a egN;

    public static synchronized a bbt() {
        a aVar;
        synchronized (b.class) {
            if (egN == null) {
                egN = new a();
            }
            aVar = egN;
        }
        return aVar;
    }
}
