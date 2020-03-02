package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes7.dex */
public class b {
    private static volatile a efJ;

    public static synchronized a baJ() {
        a aVar;
        synchronized (b.class) {
            if (efJ == null) {
                efJ = new a();
            }
            aVar = efJ;
        }
        return aVar;
    }
}
