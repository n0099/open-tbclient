package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile List<Long> dEt = new ArrayList();

    public static void bJ(long j) {
        if (dEt.size() > 300) {
            dEt.remove(0);
        }
        dEt.add(Long.valueOf(j));
    }

    public static boolean bK(long j) {
        return dEt.contains(Long.valueOf(j));
    }
}
