package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes7.dex */
public class b {
    private static volatile a efI;

    public static synchronized a baH() {
        a aVar;
        synchronized (b.class) {
            if (efI == null) {
                efI = new a();
            }
            aVar = efI;
        }
        return aVar;
    }
}
