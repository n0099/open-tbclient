package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class f {
    private static volatile List<Long> fvR = new ArrayList();

    public static void eC(long j) {
        if (fvR.size() > 300) {
            fvR.remove(0);
        }
        fvR.add(Long.valueOf(j));
    }

    public static boolean eD(long j) {
        return fvR.contains(Long.valueOf(j));
    }
}
