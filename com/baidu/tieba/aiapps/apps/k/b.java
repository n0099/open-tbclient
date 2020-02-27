package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes7.dex */
public class b {
    private static volatile a efQ;

    public static synchronized a bbb() {
        a aVar;
        synchronized (b.class) {
            if (efQ == null) {
                efQ = new a();
            }
            aVar = efQ;
        }
        return aVar;
    }
}
