package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f {
    private static volatile List<Long> ejy = new ArrayList();

    public static void dx(long j) {
        if (ejy.size() > 300) {
            ejy.remove(0);
        }
        ejy.add(Long.valueOf(j));
    }

    public static boolean dy(long j) {
        return ejy.contains(Long.valueOf(j));
    }
}
