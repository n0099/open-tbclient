package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class f {
    private static volatile List<Long> fWT = new ArrayList();

    public static void fu(long j) {
        if (fWT.size() > 300) {
            fWT.remove(0);
        }
        fWT.add(Long.valueOf(j));
    }

    public static boolean fv(long j) {
        return fWT.contains(Long.valueOf(j));
    }
}
