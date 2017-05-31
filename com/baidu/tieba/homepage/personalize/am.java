package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class am {
    private static volatile List<Long> cBD = new ArrayList();

    public static void bf(long j) {
        if (cBD.size() > 300) {
            cBD.remove(0);
        }
        cBD.add(Long.valueOf(j));
    }

    public static boolean bg(long j) {
        return cBD.contains(Long.valueOf(j));
    }
}
