package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private static volatile List<Long> ddz = new ArrayList();

    public static void cL(long j) {
        if (ddz.size() > 300) {
            ddz.remove(0);
        }
        ddz.add(Long.valueOf(j));
    }

    public static boolean cM(long j) {
        return ddz.contains(Long.valueOf(j));
    }
}
