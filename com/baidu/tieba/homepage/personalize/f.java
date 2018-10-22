package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f {
    private static volatile List<Long> enp = new ArrayList();

    public static void cb(long j) {
        if (enp.size() > 300) {
            enp.remove(0);
        }
        enp.add(Long.valueOf(j));
    }

    public static boolean cc(long j) {
        return enp.contains(Long.valueOf(j));
    }
}
