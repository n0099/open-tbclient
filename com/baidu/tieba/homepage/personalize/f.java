package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static volatile List<Long> cTC = new ArrayList();

    public static void bv(long j) {
        if (cTC.size() > 300) {
            cTC.remove(0);
        }
        cTC.add(Long.valueOf(j));
    }

    public static boolean bw(long j) {
        return cTC.contains(Long.valueOf(j));
    }
}
