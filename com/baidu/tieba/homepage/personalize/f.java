package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    private static volatile List<Long> eSD = new ArrayList();

    public static void el(long j) {
        if (eSD.size() > 300) {
            eSD.remove(0);
        }
        eSD.add(Long.valueOf(j));
    }

    public static boolean em(long j) {
        return eSD.contains(Long.valueOf(j));
    }
}
