package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile List<Long> dUm = new ArrayList();

    public static void bL(long j) {
        if (dUm.size() > 300) {
            dUm.remove(0);
        }
        dUm.add(Long.valueOf(j));
    }

    public static boolean bM(long j) {
        return dUm.contains(Long.valueOf(j));
    }
}
