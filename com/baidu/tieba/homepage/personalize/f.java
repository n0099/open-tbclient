package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    private static volatile List<Long> ffl = new ArrayList();

    public static void em(long j) {
        if (ffl.size() > 300) {
            ffl.remove(0);
        }
        ffl.add(Long.valueOf(j));
    }

    public static boolean en(long j) {
        return ffl.contains(Long.valueOf(j));
    }
}
