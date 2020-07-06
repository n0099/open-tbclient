package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes7.dex */
public class b {
    private static volatile a fdH;

    public static synchronized a brn() {
        a aVar;
        synchronized (b.class) {
            if (fdH == null) {
                fdH = new a();
            }
            aVar = fdH;
        }
        return aVar;
    }
}
