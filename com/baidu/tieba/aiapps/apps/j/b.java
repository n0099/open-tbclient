package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes20.dex */
public class b {
    private static volatile a gfn;

    public static synchronized a bOF() {
        a aVar;
        synchronized (b.class) {
            if (gfn == null) {
                gfn = new a();
            }
            aVar = gfn;
        }
        return aVar;
    }
}
