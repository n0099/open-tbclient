package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes7.dex */
public class b {
    private static volatile a ege;

    public static synchronized a bbe() {
        a aVar;
        synchronized (b.class) {
            if (ege == null) {
                ege = new a();
            }
            aVar = ege;
        }
        return aVar;
    }
}
