package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fIw;

    public static synchronized a bGE() {
        a aVar;
        synchronized (b.class) {
            if (fIw == null) {
                fIw = new a();
            }
            aVar = fIw;
        }
        return aVar;
    }
}
