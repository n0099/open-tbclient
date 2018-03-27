package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private static volatile List<Long> ejN = new ArrayList();

    public static void bL(long j) {
        if (ejN.size() > 300) {
            ejN.remove(0);
        }
        ejN.add(Long.valueOf(j));
    }

    public static boolean bM(long j) {
        return ejN.contains(Long.valueOf(j));
    }
}
