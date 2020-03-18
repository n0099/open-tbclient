package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    private static volatile List<Long> epb = new ArrayList();

    public static void dC(long j) {
        if (epb.size() > 300) {
            epb.remove(0);
        }
        epb.add(Long.valueOf(j));
    }

    public static boolean dD(long j) {
        return epb.contains(Long.valueOf(j));
    }
}
