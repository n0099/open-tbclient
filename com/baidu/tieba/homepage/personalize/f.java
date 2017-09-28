package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static volatile List<Long> cZn = new ArrayList();

    public static void bs(long j) {
        if (cZn.size() > 300) {
            cZn.remove(0);
        }
        cZn.add(Long.valueOf(j));
    }

    public static boolean bt(long j) {
        return cZn.contains(Long.valueOf(j));
    }
}
