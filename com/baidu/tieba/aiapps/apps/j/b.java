package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eTl;

    public static synchronized a boK() {
        a aVar;
        synchronized (b.class) {
            if (eTl == null) {
                eTl = new a();
            }
            aVar = eTl;
        }
        return aVar;
    }
}
