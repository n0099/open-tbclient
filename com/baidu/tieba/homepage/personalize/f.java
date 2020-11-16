package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class f {
    private static volatile List<Long> gms = new ArrayList();

    public static void fU(long j) {
        if (gms.size() > 300) {
            gms.remove(0);
        }
        gms.add(Long.valueOf(j));
    }

    public static boolean fV(long j) {
        return gms.contains(Long.valueOf(j));
    }
}
