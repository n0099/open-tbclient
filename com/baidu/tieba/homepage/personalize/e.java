package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static volatile List<Long> dQL = new ArrayList();

    public static void bP(long j) {
        if (dQL.size() > 300) {
            dQL.remove(0);
        }
        dQL.add(Long.valueOf(j));
    }

    public static boolean bQ(long j) {
        return dQL.contains(Long.valueOf(j));
    }
}
