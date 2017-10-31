package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static volatile List<Long> dhq = new ArrayList();

    public static void bu(long j) {
        if (dhq.size() > 300) {
            dhq.remove(0);
        }
        dhq.add(Long.valueOf(j));
    }

    public static boolean bv(long j) {
        return dhq.contains(Long.valueOf(j));
    }
}
