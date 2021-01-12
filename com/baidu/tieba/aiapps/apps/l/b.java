package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes6.dex */
public class b {
    private static volatile a gjZ;

    public static synchronized a bNk() {
        a aVar;
        synchronized (b.class) {
            if (gjZ == null) {
                gjZ = new a();
            }
            aVar = gjZ;
        }
        return aVar;
    }
}
