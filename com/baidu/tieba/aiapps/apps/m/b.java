package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes2.dex */
public class b {
    private static volatile a drM;

    public static synchronized a aIj() {
        a aVar;
        synchronized (b.class) {
            if (drM == null) {
                drM = new a();
            }
            aVar = drM;
        }
        return aVar;
    }
}
