package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes7.dex */
public class c {
    private static volatile b fdG;

    public static synchronized b brk() {
        b bVar;
        synchronized (c.class) {
            if (fdG == null) {
                fdG = new b();
            }
            bVar = fdG;
        }
        return bVar;
    }
}
