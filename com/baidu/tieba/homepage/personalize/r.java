package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private static volatile List<Long> cqT = new ArrayList();

    public static void bq(long j) {
        if (cqT.size() > 300) {
            cqT.remove(0);
        }
        cqT.add(Long.valueOf(j));
    }

    public static boolean br(long j) {
        return cqT.contains(Long.valueOf(j));
    }
}
