package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static volatile List<Long> cSj = new ArrayList();

    public static void bv(long j) {
        if (cSj.size() > 300) {
            cSj.remove(0);
        }
        cSj.add(Long.valueOf(j));
    }

    public static boolean bw(long j) {
        return cSj.contains(Long.valueOf(j));
    }
}
