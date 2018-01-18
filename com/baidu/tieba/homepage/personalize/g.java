package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private static volatile List<Long> efc = new ArrayList();

    public static void bJ(long j) {
        if (efc.size() > 300) {
            efc.remove(0);
        }
        efc.add(Long.valueOf(j));
    }

    public static boolean bK(long j) {
        return efc.contains(Long.valueOf(j));
    }
}
