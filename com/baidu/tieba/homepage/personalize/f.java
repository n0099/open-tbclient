package com.baidu.tieba.homepage.personalize;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private static volatile List<Long> efv = new ArrayList();

    public static void bU(long j) {
        if (efv.size() > 300) {
            efv.remove(0);
        }
        efv.add(Long.valueOf(j));
    }

    public static boolean bV(long j) {
        return efv.contains(Long.valueOf(j));
    }
}
