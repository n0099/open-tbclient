package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private static volatile List<Long> ejJ = new ArrayList();

    public static void bL(long j) {
        if (ejJ.size() > 300) {
            ejJ.remove(0);
        }
        ejJ.add(Long.valueOf(j));
    }

    public static boolean bM(long j) {
        return ejJ.contains(Long.valueOf(j));
    }
}
