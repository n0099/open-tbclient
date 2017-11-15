package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static volatile List<Long> dhK = new ArrayList();

    public static void bu(long j) {
        if (dhK.size() > 300) {
            dhK.remove(0);
        }
        dhK.add(Long.valueOf(j));
    }

    public static boolean bv(long j) {
        return dhK.contains(Long.valueOf(j));
    }
}
