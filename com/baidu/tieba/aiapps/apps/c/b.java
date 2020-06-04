package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eSI;

    public static synchronized a bog() {
        a aVar;
        synchronized (b.class) {
            if (eSI == null) {
                eSI = new a();
            }
            aVar = eSI;
        }
        return aVar;
    }
}
