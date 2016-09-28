package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ak {
    private static volatile List<Long> cGh = new ArrayList();

    public static void bH(long j) {
        if (cGh.size() > 300) {
            cGh.remove(0);
        }
        cGh.add(Long.valueOf(j));
    }

    public static boolean bI(long j) {
        return cGh.contains(Long.valueOf(j));
    }
}
