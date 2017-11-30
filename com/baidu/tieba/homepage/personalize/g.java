package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static volatile List<Long> dqz = new ArrayList();

    public static void bC(long j) {
        if (dqz.size() > 300) {
            dqz.remove(0);
        }
        dqz.add(Long.valueOf(j));
    }

    public static boolean bD(long j) {
        return dqz.contains(Long.valueOf(j));
    }
}
