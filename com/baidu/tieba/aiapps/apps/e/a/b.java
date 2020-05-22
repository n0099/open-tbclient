package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eSM;

    public static synchronized a boi() {
        a aVar;
        synchronized (b.class) {
            if (eSM == null) {
                eSM = new a();
            }
            aVar = eSM;
        }
        return aVar;
    }
}
