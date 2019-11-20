package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dpu;

    public static synchronized a aGT() {
        a aVar;
        synchronized (b.class) {
            if (dpu == null) {
                dpu = new a();
            }
            aVar = dpu;
        }
        return aVar;
    }
}
