package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes7.dex */
public class b {
    private static volatile a goG;

    public static synchronized a bRc() {
        a aVar;
        synchronized (b.class) {
            if (goG == null) {
                goG = new a();
            }
            aVar = goG;
        }
        return aVar;
    }
}
