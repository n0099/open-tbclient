package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private static volatile List<Long> dsd = new ArrayList();

    public static void ds(long j) {
        if (dsd.size() > 300) {
            dsd.remove(0);
        }
        dsd.add(Long.valueOf(j));
    }

    public static boolean dt(long j) {
        return dsd.contains(Long.valueOf(j));
    }
}
