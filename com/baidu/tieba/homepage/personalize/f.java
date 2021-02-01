package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private static volatile List<Long> gDG = new ArrayList();

    public static void gE(long j) {
        if (gDG.size() > 300) {
            gDG.remove(0);
        }
        gDG.add(Long.valueOf(j));
    }

    public static boolean gF(long j) {
        return gDG.contains(Long.valueOf(j));
    }
}
