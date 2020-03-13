package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes7.dex */
public class b {
    private static volatile a efV;

    public static synchronized a baI() {
        a aVar;
        synchronized (b.class) {
            if (efV == null) {
                efV = new a();
            }
            aVar = efV;
        }
        return aVar;
    }
}
