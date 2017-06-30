package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ay {
    private static volatile List<Long> cJA = new ArrayList();

    public static void bt(long j) {
        if (cJA.size() > 300) {
            cJA.remove(0);
        }
        cJA.add(Long.valueOf(j));
    }

    public static boolean bu(long j) {
        return cJA.contains(Long.valueOf(j));
    }
}
