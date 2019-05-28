package com.baidu.tieba.aiapps.apps.address;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dai;

    public static synchronized a aDu() {
        a aVar;
        synchronized (b.class) {
            if (dai == null) {
                dai = new a();
            }
            aVar = dai;
        }
        return aVar;
    }
}
