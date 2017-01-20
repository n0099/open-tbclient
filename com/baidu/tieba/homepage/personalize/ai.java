package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ai {
    private static volatile List<Long> cxO = new ArrayList();

    public static void bp(long j) {
        if (cxO.size() > 300) {
            cxO.remove(0);
        }
        cxO.add(Long.valueOf(j));
    }

    public static boolean bq(long j) {
        return cxO.contains(Long.valueOf(j));
    }
}
