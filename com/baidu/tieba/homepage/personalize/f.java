package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f {
    private static volatile List<Long> ezh = new ArrayList();

    public static void ci(long j) {
        if (ezh.size() > 300) {
            ezh.remove(0);
        }
        ezh.add(Long.valueOf(j));
    }

    public static boolean cj(long j) {
        return ezh.contains(Long.valueOf(j));
    }
}
