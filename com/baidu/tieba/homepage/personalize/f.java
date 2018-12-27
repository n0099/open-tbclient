package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f {
    private static volatile List<Long> eyw = new ArrayList();

    public static void ci(long j) {
        if (eyw.size() > 300) {
            eyw.remove(0);
        }
        eyw.add(Long.valueOf(j));
    }

    public static boolean cj(long j) {
        return eyw.contains(Long.valueOf(j));
    }
}
