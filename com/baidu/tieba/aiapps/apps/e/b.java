package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eEc;

    public static synchronized a bhX() {
        a aVar;
        synchronized (b.class) {
            if (eEc == null) {
                eEc = new a();
            }
            aVar = eEc;
        }
        return aVar;
    }
}
