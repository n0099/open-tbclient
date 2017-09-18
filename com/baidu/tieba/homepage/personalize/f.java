package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static volatile List<Long> dcZ = new ArrayList();

    public static void bv(long j) {
        if (dcZ.size() > 300) {
            dcZ.remove(0);
        }
        dcZ.add(Long.valueOf(j));
    }

    public static boolean bw(long j) {
        return dcZ.contains(Long.valueOf(j));
    }
}
