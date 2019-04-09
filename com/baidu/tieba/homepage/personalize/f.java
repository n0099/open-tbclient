package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private static volatile List<Long> ddA = new ArrayList();

    public static void cL(long j) {
        if (ddA.size() > 300) {
            ddA.remove(0);
        }
        ddA.add(Long.valueOf(j));
    }

    public static boolean cM(long j) {
        return ddA.contains(Long.valueOf(j));
    }
}
