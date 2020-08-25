package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class f {
    private static volatile List<Long> fHj = new ArrayList();

    public static void eO(long j) {
        if (fHj.size() > 300) {
            fHj.remove(0);
        }
        fHj.add(Long.valueOf(j));
    }

    public static boolean eP(long j) {
        return fHj.contains(Long.valueOf(j));
    }
}
