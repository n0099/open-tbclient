package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private static volatile List<Long> dyw = new ArrayList();

    public static void cR(long j) {
        if (dyw.size() > 300) {
            dyw.remove(0);
        }
        dyw.add(Long.valueOf(j));
    }

    public static boolean cS(long j) {
        return dyw.contains(Long.valueOf(j));
    }
}
