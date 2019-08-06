package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private static volatile List<Long> dqs = new ArrayList();

    public static void dp(long j) {
        if (dqs.size() > 300) {
            dqs.remove(0);
        }
        dqs.add(Long.valueOf(j));
    }

    public static boolean dq(long j) {
        return dqs.contains(Long.valueOf(j));
    }
}
