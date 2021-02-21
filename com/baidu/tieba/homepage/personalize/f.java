package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private static volatile List<Long> gDU = new ArrayList();

    public static void gE(long j) {
        if (gDU.size() > 300) {
            gDU.remove(0);
        }
        gDU.add(Long.valueOf(j));
    }

    public static boolean gF(long j) {
        return gDU.contains(Long.valueOf(j));
    }
}
