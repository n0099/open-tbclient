package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private static volatile List<Long> ejx = new ArrayList();

    public static void bL(long j) {
        if (ejx.size() > 300) {
            ejx.remove(0);
        }
        ejx.add(Long.valueOf(j));
    }

    public static boolean bM(long j) {
        return ejx.contains(Long.valueOf(j));
    }
}
