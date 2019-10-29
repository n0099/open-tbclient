package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private static volatile List<Long> dzn = new ArrayList();

    public static void cS(long j) {
        if (dzn.size() > 300) {
            dzn.remove(0);
        }
        dzn.add(Long.valueOf(j));
    }

    public static boolean cT(long j) {
        return dzn.contains(Long.valueOf(j));
    }
}
