package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f {
    private static volatile List<Long> ezg = new ArrayList();

    public static void ci(long j) {
        if (ezg.size() > 300) {
            ezg.remove(0);
        }
        ezg.add(Long.valueOf(j));
    }

    public static boolean cj(long j) {
        return ezg.contains(Long.valueOf(j));
    }
}
