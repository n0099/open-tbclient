package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile List<Long> dYe = new ArrayList();

    public static void bQ(long j) {
        if (dYe.size() > 300) {
            dYe.remove(0);
        }
        dYe.add(Long.valueOf(j));
    }

    public static boolean bR(long j) {
        return dYe.contains(Long.valueOf(j));
    }
}
