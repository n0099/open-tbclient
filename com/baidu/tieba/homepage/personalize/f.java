package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class f {
    private static volatile List<Long> fHn = new ArrayList();

    public static void eO(long j) {
        if (fHn.size() > 300) {
            fHn.remove(0);
        }
        fHn.add(Long.valueOf(j));
    }

    public static boolean eP(long j) {
        return fHn.contains(Long.valueOf(j));
    }
}
