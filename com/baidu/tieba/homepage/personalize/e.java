package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile List<Long> dYb = new ArrayList();

    public static void bQ(long j) {
        if (dYb.size() > 300) {
            dYb.remove(0);
        }
        dYb.add(Long.valueOf(j));
    }

    public static boolean bR(long j) {
        return dYb.contains(Long.valueOf(j));
    }
}
