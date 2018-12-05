package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f {
    private static volatile List<Long> evD = new ArrayList();

    public static void cd(long j) {
        if (evD.size() > 300) {
            evD.remove(0);
        }
        evD.add(Long.valueOf(j));
    }

    public static boolean ce(long j) {
        return evD.contains(Long.valueOf(j));
    }
}
