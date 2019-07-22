package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private static volatile List<Long> dql = new ArrayList();

    public static void dp(long j) {
        if (dql.size() > 300) {
            dql.remove(0);
        }
        dql.add(Long.valueOf(j));
    }

    public static boolean dq(long j) {
        return dql.contains(Long.valueOf(j));
    }
}
