package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    private static volatile List<Long> ffw = new ArrayList();

    public static void em(long j) {
        if (ffw.size() > 300) {
            ffw.remove(0);
        }
        ffw.add(Long.valueOf(j));
    }

    public static boolean en(long j) {
        return ffw.contains(Long.valueOf(j));
    }
}
