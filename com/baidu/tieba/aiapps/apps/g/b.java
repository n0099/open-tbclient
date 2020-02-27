package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes7.dex */
public class b {
    private static volatile a efH;

    public static synchronized a baF() {
        a aVar;
        synchronized (b.class) {
            if (efH == null) {
                efH = new a();
            }
            aVar = efH;
        }
        return aVar;
    }
}
