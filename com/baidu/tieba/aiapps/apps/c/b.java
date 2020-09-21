package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes19.dex */
public class b {
    private static volatile a fwn;

    public static synchronized a bDS() {
        a aVar;
        synchronized (b.class) {
            if (fwn == null) {
                fwn = new a();
            }
            aVar = fwn;
        }
        return aVar;
    }
}
