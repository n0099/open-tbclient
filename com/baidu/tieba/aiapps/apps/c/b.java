package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eDT;

    public static synchronized a bhW() {
        a aVar;
        synchronized (b.class) {
            if (eDT == null) {
                eDT = new a();
            }
            aVar = eDT;
        }
        return aVar;
    }
}
