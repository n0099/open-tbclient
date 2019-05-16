package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private static volatile List<Long> dob = new ArrayList();

    public static void di(long j) {
        if (dob.size() > 300) {
            dob.remove(0);
        }
        dob.add(Long.valueOf(j));
    }

    public static boolean dj(long j) {
        return dob.contains(Long.valueOf(j));
    }
}
