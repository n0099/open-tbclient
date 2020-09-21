package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class f {
    private static volatile List<Long> fKz = new ArrayList();

    public static void fc(long j) {
        if (fKz.size() > 300) {
            fKz.remove(0);
        }
        fKz.add(Long.valueOf(j));
    }

    public static boolean fd(long j) {
        return fKz.contains(Long.valueOf(j));
    }
}
