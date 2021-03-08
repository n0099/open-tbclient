package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes6.dex */
public class b {
    private static volatile a goD;

    public static synchronized a bNY() {
        a aVar;
        synchronized (b.class) {
            if (goD == null) {
                goD = new a();
            }
            aVar = goD;
        }
        return aVar;
    }
}
