package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class f {
    private static volatile List<Long> guB = new ArrayList();

    public static void gz(long j) {
        if (guB.size() > 300) {
            guB.remove(0);
        }
        guB.add(Long.valueOf(j));
    }

    public static boolean gA(long j) {
        return guB.contains(Long.valueOf(j));
    }
}
