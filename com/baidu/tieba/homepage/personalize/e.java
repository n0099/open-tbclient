package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile List<Long> dEq = new ArrayList();

    public static void bJ(long j) {
        if (dEq.size() > 300) {
            dEq.remove(0);
        }
        dEq.add(Long.valueOf(j));
    }

    public static boolean bK(long j) {
        return dEq.contains(Long.valueOf(j));
    }
}
