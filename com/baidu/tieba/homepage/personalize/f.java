package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f {
    private static volatile List<Long> eno = new ArrayList();

    public static void cb(long j) {
        if (eno.size() > 300) {
            eno.remove(0);
        }
        eno.add(Long.valueOf(j));
    }

    public static boolean cc(long j) {
        return eno.contains(Long.valueOf(j));
    }
}
