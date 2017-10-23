package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static volatile List<Long> cZa = new ArrayList();

    public static void bt(long j) {
        if (cZa.size() > 300) {
            cZa.remove(0);
        }
        cZa.add(Long.valueOf(j));
    }

    public static boolean bu(long j) {
        return cZa.contains(Long.valueOf(j));
    }
}
