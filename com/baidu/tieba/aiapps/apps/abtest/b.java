package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dmk;

    public static synchronized a aFn() {
        a aVar;
        synchronized (b.class) {
            if (dmk == null) {
                dmk = new a();
            }
            aVar = dmk;
        }
        return aVar;
    }
}
