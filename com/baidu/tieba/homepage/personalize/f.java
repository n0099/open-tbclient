package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static volatile List<Long> cVB = new ArrayList();

    public static void bv(long j) {
        if (cVB.size() > 300) {
            cVB.remove(0);
        }
        cVB.add(Long.valueOf(j));
    }

    public static boolean bw(long j) {
        return cVB.contains(Long.valueOf(j));
    }
}
