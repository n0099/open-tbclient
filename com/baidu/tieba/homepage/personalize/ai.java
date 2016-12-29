package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ai {
    private static volatile List<Long> cqN = new ArrayList();

    public static void bu(long j) {
        if (cqN.size() > 300) {
            cqN.remove(0);
        }
        cqN.add(Long.valueOf(j));
    }

    public static boolean bv(long j) {
        return cqN.contains(Long.valueOf(j));
    }
}
