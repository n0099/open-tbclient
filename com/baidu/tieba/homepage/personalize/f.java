package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    private static volatile List<Long> fqH = new ArrayList();

    public static void ep(long j) {
        if (fqH.size() > 300) {
            fqH.remove(0);
        }
        fqH.add(Long.valueOf(j));
    }

    public static boolean eq(long j) {
        return fqH.contains(Long.valueOf(j));
    }
}
