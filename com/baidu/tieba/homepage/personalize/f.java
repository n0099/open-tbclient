package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private static volatile List<Long> gFC = new ArrayList();

    public static void gz(long j) {
        if (gFC.size() > 300) {
            gFC.remove(0);
        }
        gFC.add(Long.valueOf(j));
    }

    public static boolean gA(long j) {
        return gFC.contains(Long.valueOf(j));
    }
}
