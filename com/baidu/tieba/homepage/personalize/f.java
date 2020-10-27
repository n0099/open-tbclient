package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class f {
    private static volatile List<Long> ggX = new ArrayList();

    public static void fv(long j) {
        if (ggX.size() > 300) {
            ggX.remove(0);
        }
        ggX.add(Long.valueOf(j));
    }

    public static boolean fw(long j) {
        return ggX.contains(Long.valueOf(j));
    }
}
