package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private static volatile List<Long> dod = new ArrayList();

    public static void di(long j) {
        if (dod.size() > 300) {
            dod.remove(0);
        }
        dod.add(Long.valueOf(j));
    }

    public static boolean dj(long j) {
        return dod.contains(Long.valueOf(j));
    }
}
