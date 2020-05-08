package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eEr;

    public static synchronized a bib() {
        a aVar;
        synchronized (b.class) {
            if (eEr == null) {
                eEr = new a();
            }
            aVar = eEr;
        }
        return aVar;
    }
}
