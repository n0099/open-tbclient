package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private static volatile List<Long> gAW = new ArrayList();

    public static void gz(long j) {
        if (gAW.size() > 300) {
            gAW.remove(0);
        }
        gAW.add(Long.valueOf(j));
    }

    public static boolean gA(long j) {
        return gAW.contains(Long.valueOf(j));
    }
}
