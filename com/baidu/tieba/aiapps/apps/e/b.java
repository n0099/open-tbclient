package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eeg;

    public static synchronized a aZV() {
        a aVar;
        synchronized (b.class) {
            if (eeg == null) {
                eeg = new a();
            }
            aVar = eeg;
        }
        return aVar;
    }
}
