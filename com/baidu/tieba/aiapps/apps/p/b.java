package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes5.dex */
public class b {
    private static volatile a ecg;

    public static synchronized a aYX() {
        a aVar;
        synchronized (b.class) {
            if (ecg == null) {
                ecg = new a();
            }
            aVar = ecg;
        }
        return aVar;
    }
}
