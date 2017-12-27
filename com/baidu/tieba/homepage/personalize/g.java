package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private static volatile List<Long> edO = new ArrayList();

    public static void bL(long j) {
        if (edO.size() > 300) {
            edO.remove(0);
        }
        edO.add(Long.valueOf(j));
    }

    public static boolean bM(long j) {
        return edO.contains(Long.valueOf(j));
    }
}
