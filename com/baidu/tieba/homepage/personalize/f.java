package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    private static volatile List<Long> eoK = new ArrayList();

    public static void dC(long j) {
        if (eoK.size() > 300) {
            eoK.remove(0);
        }
        eoK.add(Long.valueOf(j));
    }

    public static boolean dD(long j) {
        return eoK.contains(Long.valueOf(j));
    }
}
