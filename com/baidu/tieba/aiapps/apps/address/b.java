package com.baidu.tieba.aiapps.apps.address;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dmg;

    public static synchronized a aFA() {
        a aVar;
        synchronized (b.class) {
            if (dmg == null) {
                dmg = new a();
            }
            aVar = dmg;
        }
        return aVar;
    }
}
