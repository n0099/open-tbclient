package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes7.dex */
public class b {
    private static volatile a efW;

    public static synchronized a baK() {
        a aVar;
        synchronized (b.class) {
            if (efW == null) {
                efW = new a();
            }
            aVar = efW;
        }
        return aVar;
    }
}
