package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static volatile List<Long> drE = new ArrayList();

    public static void bC(long j) {
        if (drE.size() > 300) {
            drE.remove(0);
        }
        drE.add(Long.valueOf(j));
    }

    public static boolean bD(long j) {
        return drE.contains(Long.valueOf(j));
    }
}
