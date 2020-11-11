package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class f {
    private static volatile List<Long> gmL = new ArrayList();

    public static void fR(long j) {
        if (gmL.size() > 300) {
            gmL.remove(0);
        }
        gmL.add(Long.valueOf(j));
    }

    public static boolean fS(long j) {
        return gmL.contains(Long.valueOf(j));
    }
}
