package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ai {
    private static volatile List<Long> cLs = new ArrayList();

    public static void bG(long j) {
        if (cLs.size() > 300) {
            cLs.remove(0);
        }
        cLs.add(Long.valueOf(j));
    }

    public static boolean bH(long j) {
        return cLs.contains(Long.valueOf(j));
    }
}
