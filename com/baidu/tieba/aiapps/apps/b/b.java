package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eSu;

    public static synchronized a boc() {
        a aVar;
        synchronized (b.class) {
            if (eSu == null) {
                eSu = new a();
            }
            aVar = eSu;
        }
        return aVar;
    }
}
