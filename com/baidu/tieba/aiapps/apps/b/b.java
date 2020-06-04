package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eSF;

    public static synchronized a boe() {
        a aVar;
        synchronized (b.class) {
            if (eSF == null) {
                eSF = new a();
            }
            aVar = eSF;
        }
        return aVar;
    }
}
