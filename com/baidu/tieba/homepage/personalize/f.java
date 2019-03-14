package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private static volatile List<Long> ddv = new ArrayList();

    public static void cL(long j) {
        if (ddv.size() > 300) {
            ddv.remove(0);
        }
        ddv.add(Long.valueOf(j));
    }

    public static boolean cM(long j) {
        return ddv.contains(Long.valueOf(j));
    }
}
