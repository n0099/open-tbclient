package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes6.dex */
public class b {
    private static volatile a goB;

    public static synchronized a bNV() {
        a aVar;
        synchronized (b.class) {
            if (goB == null) {
                goB = new a();
            }
            aVar = goB;
        }
        return aVar;
    }
}
