package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    private static volatile List<Long> eow = new ArrayList();

    public static void dC(long j) {
        if (eow.size() > 300) {
            eow.remove(0);
        }
        eow.add(Long.valueOf(j));
    }

    public static boolean dD(long j) {
        return eow.contains(Long.valueOf(j));
    }
}
