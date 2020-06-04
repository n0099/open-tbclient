package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eSX;

    public static synchronized a bok() {
        a aVar;
        synchronized (b.class) {
            if (eSX == null) {
                eSX = new a();
            }
            aVar = eSX;
        }
        return aVar;
    }
}
