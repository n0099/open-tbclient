package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class f {
    private static volatile List<Long> ekl = new ArrayList();

    public static void dC(long j) {
        if (ekl.size() > 300) {
            ekl.remove(0);
        }
        ekl.add(Long.valueOf(j));
    }

    public static boolean dD(long j) {
        return ekl.contains(Long.valueOf(j));
    }
}
