package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    private static volatile List<Long> eox = new ArrayList();

    public static void dC(long j) {
        if (eox.size() > 300) {
            eox.remove(0);
        }
        eox.add(Long.valueOf(j));
    }

    public static boolean dD(long j) {
        return eox.contains(Long.valueOf(j));
    }
}
