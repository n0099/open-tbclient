package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class am {
    private static volatile List<Long> cvl = new ArrayList();

    public static void bc(long j) {
        if (cvl.size() > 300) {
            cvl.remove(0);
        }
        cvl.add(Long.valueOf(j));
    }

    public static boolean bd(long j) {
        return cvl.contains(Long.valueOf(j));
    }
}
