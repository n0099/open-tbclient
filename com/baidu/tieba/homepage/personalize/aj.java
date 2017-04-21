package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class aj {
    private static volatile List<Long> cAb = new ArrayList();

    public static void bp(long j) {
        if (cAb.size() > 300) {
            cAb.remove(0);
        }
        cAb.add(Long.valueOf(j));
    }

    public static boolean bq(long j) {
        return cAb.contains(Long.valueOf(j));
    }
}
