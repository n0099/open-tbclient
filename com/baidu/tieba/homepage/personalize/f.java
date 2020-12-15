package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class f {
    private static volatile List<Long> guD = new ArrayList();

    public static void gz(long j) {
        if (guD.size() > 300) {
            guD.remove(0);
        }
        guD.add(Long.valueOf(j));
    }

    public static boolean gA(long j) {
        return guD.contains(Long.valueOf(j));
    }
}
