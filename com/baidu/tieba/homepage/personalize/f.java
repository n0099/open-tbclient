package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static volatile List<Long> dce = new ArrayList();

    public static void bv(long j) {
        if (dce.size() > 300) {
            dce.remove(0);
        }
        dce.add(Long.valueOf(j));
    }

    public static boolean bw(long j) {
        return dce.contains(Long.valueOf(j));
    }
}
