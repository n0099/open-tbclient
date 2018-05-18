package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile List<Long> dFw = new ArrayList();

    public static void bJ(long j) {
        if (dFw.size() > 300) {
            dFw.remove(0);
        }
        dFw.add(Long.valueOf(j));
    }

    public static boolean bK(long j) {
        return dFw.contains(Long.valueOf(j));
    }
}
