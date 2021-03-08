package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private static volatile List<Long> gFD = new ArrayList();

    public static void gE(long j) {
        if (gFD.size() > 300) {
            gFD.remove(0);
        }
        gFD.add(Long.valueOf(j));
    }

    public static boolean gF(long j) {
        return gFD.contains(Long.valueOf(j));
    }
}
