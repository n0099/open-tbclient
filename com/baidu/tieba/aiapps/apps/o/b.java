package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes7.dex */
public class b {
    private static volatile a egM;

    public static synchronized a bbs() {
        a aVar;
        synchronized (b.class) {
            if (egM == null) {
                egM = new a();
            }
            aVar = egM;
        }
        return aVar;
    }
}
