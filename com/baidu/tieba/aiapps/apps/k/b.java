package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes7.dex */
public class b {
    private static volatile a efR;

    public static synchronized a bbd() {
        a aVar;
        synchronized (b.class) {
            if (efR == null) {
                efR = new a();
            }
            aVar = efR;
        }
        return aVar;
    }
}
