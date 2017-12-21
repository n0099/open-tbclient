package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static volatile List<Long> drI = new ArrayList();

    public static void bC(long j) {
        if (drI.size() > 300) {
            drI.remove(0);
        }
        drI.add(Long.valueOf(j));
    }

    public static boolean bD(long j) {
        return drI.contains(Long.valueOf(j));
    }
}
