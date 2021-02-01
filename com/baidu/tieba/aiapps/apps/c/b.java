package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes7.dex */
public class b {
    private static volatile a glR;

    public static synchronized a bNa() {
        a aVar;
        synchronized (b.class) {
            if (glR == null) {
                glR = new a();
            }
            aVar = glR;
        }
        return aVar;
    }
}
