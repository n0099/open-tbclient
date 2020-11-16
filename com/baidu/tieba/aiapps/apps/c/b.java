package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes19.dex */
public class b {
    private static volatile a fWo;

    public static synchronized a bKp() {
        a aVar;
        synchronized (b.class) {
            if (fWo == null) {
                fWo = new a();
            }
            aVar = fWo;
        }
        return aVar;
    }
}
