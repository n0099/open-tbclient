package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    private static volatile List<Long> eSy = new ArrayList();

    public static void el(long j) {
        if (eSy.size() > 300) {
            eSy.remove(0);
        }
        eSy.add(Long.valueOf(j));
    }

    public static boolean em(long j) {
        return eSy.contains(Long.valueOf(j));
    }
}
