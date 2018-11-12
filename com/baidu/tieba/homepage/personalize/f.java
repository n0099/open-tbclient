package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f {
    private static volatile List<Long> eoJ = new ArrayList();

    public static void bW(long j) {
        if (eoJ.size() > 300) {
            eoJ.remove(0);
        }
        eoJ.add(Long.valueOf(j));
    }

    public static boolean bX(long j) {
        return eoJ.contains(Long.valueOf(j));
    }
}
